package com.anunad.WalletVerification.controller;

import com.anunad.WalletVerification.helper.Nagad.AuthorizationResponse;
import com.anunad.WalletVerification.helper.WalletStatus;
import com.anunad.WalletVerification.helper.Nagad.NagadVerificationHelper;
import com.anunad.WalletVerification.helper.Upay.UpayVerificationHelper;
import com.anunad.WalletVerification.model.WalletValidation;
import com.anunad.WalletVerification.service.*;
import com.anunad.WalletVerification.util.VerifyRequest;
import com.anunad.WalletVerification.model.Beneficiary;
import com.anunad.WalletVerification.model.BeneficiaryWalletValidation;
import com.anunad.WalletVerification.util.Constant;
import com.anunad.WalletVerification.helper.Nagad.NagadHTTPRequestUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasel
 */
@Controller
public class WalletValidationController {

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

//    @Autowired
//    WalletService walletService;
    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private BeneficiaryWalletValidationService beneficiaryWalletValidationService;

    @Autowired
    private WalletValidationService walletValidationService;

    @Autowired
    private MobileBankingProviderService mobileBankingProviderService;

    /**
     *
     * @return
     */
    @GetMapping(value = "/nagad/auth")
    @ResponseBody
    public String authorizeNagad() {

        AuthorizationResponse authorizationResponse = NagadHTTPRequestUtil.callNagadAuthAPI(NagadHTTPRequestUtil.REQUEST_IDENTIFIER.NagadAuth);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        return jsonObject.toString();
    }

    /**
     *
     * @param limit
     * @return
     */
    @GetMapping(value = "/validate")
    @ResponseBody
    public String validateWallet(@RequestParam(name = "limit") int limit) {

        List<Beneficiary> beneficiaryList = beneficiaryService.findBenForWalletValidation(Constant.STATUS_DEFAULT, limit);
        List<Integer> idList = new ArrayList<>();

        for (int i = 0; i < beneficiaryList.size(); i++) {
            idList.add(beneficiaryList.get(i).getId());
        }

        beneficiaryService.setAccountVerificationStatus(idList, Constant.STATUS_INTERMIDIATE);

        List<Integer> triedList = new ArrayList<>();
        List<Integer> successList = new ArrayList<>();
        List<Integer> failedList = new ArrayList<>();

        for (int i = 0; i < beneficiaryList.size(); i++) {
            Beneficiary temp = beneficiaryList.get(i);

            WalletStatus walletStatus = new WalletStatus();
            int walletType = temp.getMobileBankingProvider() != null ? temp.getMobileBankingProvider().intValue() : -1;

            switch (walletType) {
                case Constant.WALLET_NAGAD:
                    walletStatus = NagadVerificationHelper.getNagadWalletValidation(temp.getNid().toString(), temp.getAccountNo());
                    break;
                case Constant.WALLET_UPAY:
                    walletStatus = UpayVerificationHelper.getUpayWalletValidation(temp.getNid().toString(), temp.getAccountNo());
                    break;
                default:
                    walletStatus.setError(true);
            }

            int status = 0;
            if (walletStatus.isError()) {
                status = Constant.STATUS_DEFAULT;
                triedList.add(temp.getId());
                System.out.println("triedList: " + temp.getId());
            } else if (walletStatus.isValid()) {
                status = Constant.STATUS_SUCCESS;
                successList.add(temp.getId());
                System.out.println("successList: " + temp.getId());
            } else {
                status = Constant.STATUS_FAILED;
                failedList.add(temp.getId());
                System.out.println("failedList: " + temp.getId());
            }

            walletValidationService.updateOrInsertWalletValidation(
                    temp.getId(), temp.getMobileBankingProvider(), temp.getAccountNo(), status
            );
        }

        beneficiaryService.setAccountVerificationStatus(successList, Constant.STATUS_SUCCESS);
        beneficiaryService.setAccountVerificationStatus(failedList, Constant.STATUS_FAILED);
        beneficiaryService.setAccountVerificationStatus(triedList, Constant.STATUS_DEFAULT);

        List<WalletValidation> walletValidationList = new ArrayList<>();
        /*
        HashMap<Integer, WalletValidation> walletMap = new HashMap<>();
        for(int i=0;i<beneficiaryList.size();i++){
            Beneficiary ben = beneficiaryList.get(i);
            WalletValidation wallet = walletValidationService.findByBenAccountTypeAccountNo(
                    ben.getId(), ben.getMobileBankingProvider(),
                    ben.getAccountNo());
//            walletMap.put(ben.getId(), wallet);
            if(wallet == null){
//                WalletValidation w = new WalletValidation();
//                w.setBeneficiaryId(ben.getId());
//                w.setMobileBankingProviderId(ben.getMobileBankingProvider());
//                w.setAccountNo(ben.getAccountNo());
//
//                walletValidationService.save(w);
            }else {
//                wallet.setAttempt(wallet.getAttempt()+1);
//                walletValidationService.save(wallet);
            }
        }
         */
        WalletStatus walletStatus = new WalletStatus();
        walletStatus.setError(true);
        walletStatus.setValid(false);
        walletStatus.setResponse("ruinnig");

        return gson.toJson(walletStatus);
    }

    /**
     *
     * @param verifyRequest
     * @param request
     * @return
     */
    @PostMapping(value = "/api/check")
    @ResponseBody
    public String checkWallet(@RequestBody VerifyRequest verifyRequest, HttpServletRequest request) {

        WalletStatus walletStatus = new WalletStatus();
        switch (verifyRequest.getMfs()) {
            case Constant.NAGAD:
                walletStatus = NagadVerificationHelper.getNagadWalletValidation(verifyRequest.getNid(), verifyRequest.getAccountNo());
                break;
            case Constant.UPAY:
                walletStatus = UpayVerificationHelper.getUpayWalletValidation(verifyRequest.getNid(), verifyRequest.getAccountNo());
                break;
            default:
                walletStatus.setError(true);
        }

        return gson.toJson(walletStatus);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/test")
    @ResponseBody
    public String test() {

        List<Beneficiary> beneficiaryList = beneficiaryService.findBeneficiariesByStatusAndLimitAttempt(0, 5);

        int count = 0;
        for (int i = 0; i < beneficiaryList.size(); i++) {
            if (beneficiaryList.get(i).getBeneficiaryWalletValidation() == null) {
                System.out.println("id: " + beneficiaryList.get(i).getId() + " Validation null");
            } else {
                System.out.println("id: " + beneficiaryList.get(i).getId() + " Attempt: " + beneficiaryList.get(i).getBeneficiaryWalletValidation().getAttempt());
            }
        }

        WalletStatus walletStatus = new WalletStatus();
        walletStatus.setError(true);
        walletStatus.setValid(false);
        walletStatus.setResponse("ruinnig");

        return gson.toJson(walletStatus);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/ver")
    @ResponseBody
    public String checkSaveUpdate() {
        BeneficiaryWalletValidation beneficiaryWalletValidation = new BeneficiaryWalletValidation();
        beneficiaryWalletValidation.setId(10281);
        beneficiaryWalletValidation.setModifiedTime(new Timestamp(System.currentTimeMillis()));
        beneficiaryWalletValidation.setAttempt(100);

        beneficiaryWalletValidationService.save(beneficiaryWalletValidation);

        WalletStatus walletStatus = new WalletStatus();
        walletStatus.setError(true);
        walletStatus.setValid(false);
        walletStatus.setResponse("ruinnig");

        return gson.toJson(walletStatus);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/login")
    public String view() {

        return "login";
    }

}
