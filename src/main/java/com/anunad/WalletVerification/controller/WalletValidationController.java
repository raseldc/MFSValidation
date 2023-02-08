package com.anunad.WalletVerification.controller;


import com.anunad.WalletVerification.helper.Nagad.AuthorizationResponse;
import com.anunad.WalletVerification.helper.Nagad.WalletStatus;
import com.anunad.WalletVerification.helper.NagadVerificationHelper;
import com.anunad.WalletVerification.helper.VerifyReponse;
import com.anunad.WalletVerification.helper.VerifyRequest;
import com.anunad.WalletVerification.model.Beneficiary;
import com.anunad.WalletVerification.model.BeneficiaryWalletValidation;
import com.anunad.WalletVerification.service.AccountTypeService;
import com.anunad.WalletVerification.service.BeneficiaryService;
import com.anunad.WalletVerification.service.BeneficiaryWalletValidationService;
import com.anunad.WalletVerification.service.MobileBankingProviderService;
import com.anunad.WalletVerification.util.Constant;
import com.anunad.WalletVerification.util.HTTPRequestUtil;
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
    private MobileBankingProviderService mobileBankingProviderService;

    @GetMapping(value = "/nagad/auth")
    @ResponseBody
    public String authorizeNagad() {

        AuthorizationResponse authorizationResponse = HTTPRequestUtil.callNagadAuthAPI(HTTPRequestUtil.REQUEST_IDENTIFIER.NagadAuth);

        JSONObject  jsonObject=new JSONObject();
        jsonObject.put("status", "ok");
        return jsonObject.toString();
    }


    @GetMapping(value = "/validate")
    @ResponseBody
    public String validateWallet(@RequestParam(name = "limit") int limit)
    //public String validateWallet()
    {
//        MobileBankingProvider mobileBankingProvider = mobileBankingProviderService.findProvideById(typeId);

//        List<Beneficiary> beneficiaryList = beneficiaryService.findBeneficiariesByMfsIdAndStatusAndLimit(mobileBankingProvider.getId(),
//                Constant.STATUS_DEFAULT, 10);
        List<Beneficiary> beneficiaryList = beneficiaryService.findBeneficiariesByStatusAndLimit(Constant.STATUS_DEFAULT, limit);

        List<Integer> idList = new ArrayList<>();

        for (int i=0; i<beneficiaryList.size(); i++){
            idList.add(beneficiaryList.get(i).getId());
        }

        beneficiaryService.setAccountVerificationStatus(idList, Constant.STATUS_INTERMIDIATE);

        List<Integer> triedList = new ArrayList<>();
        List<Integer> successList = new ArrayList<>();
        List<Integer> failedList = new ArrayList<>();

        for(int i=0; i<beneficiaryList.size(); i++){
            Beneficiary temp = beneficiaryList.get(i);

            WalletStatus walletStatus = new WalletStatus();
            int wallet = temp.getMobileBankingProvider() != null ? temp.getMobileBankingProvider().intValue() : -1;

            switch (wallet){
                case Constant.WALLET_NAGAD:
                    walletStatus = NagadVerificationHelper.getNagadWalletValidation(temp.getNid().toString(), temp.getAccountNo());
                    break;
                default:
                    walletStatus.setError(true);
            }

            if(walletStatus.isError()){
                triedList.add(temp.getId());
                System.out.println("triedList: "+temp.getId());
            }else if(walletStatus.isValid()){
                successList.add(temp.getId());
                System.out.println("successList: "+temp.getId());
            }else{
                failedList.add(temp.getId());
                System.out.println("failedList: "+temp.getId());
            }
        }

        beneficiaryService.setAccountVerificationStatus(successList, Constant.STATUS_SUCCESS);
        beneficiaryService.setAccountVerificationStatus(failedList, Constant.STATUS_FAILED);
        beneficiaryService.setAccountVerificationStatus(triedList, Constant.STATUS_DEFAULT);

        WalletStatus walletStatus = new WalletStatus();
        walletStatus.setError(true);
        walletStatus.setValid(false);
        walletStatus.setResponse("ruinnig");

        return gson.toJson(walletStatus);
    }


    @PostMapping(value = "/api/check")
    @ResponseBody
    public String checkWallet(@RequestBody VerifyRequest verifyRequest, HttpServletRequest request){

        WalletStatus walletStatus = new WalletStatus();
        switch (verifyRequest.getMfs()){
            case Constant.NAGAD :
                walletStatus = NagadVerificationHelper.getNagadWalletValidation(verifyRequest.getNid(), verifyRequest.getAccountNo());
                break;
            default:
                walletStatus.setError(true);
        }

        return gson.toJson(walletStatus);
    }


    @GetMapping(value = "/test")
    @ResponseBody
    public String test(){

        List<Beneficiary> beneficiaryList = beneficiaryService.findBeneficiariesByStatusAndLimitAttempt(0, 5);

        int count=0;
        for(int i=0;i<beneficiaryList.size();i++){
            if(beneficiaryList.get(i).getBeneficiaryWalletValidation() ==null){
                System.out.println("id: " + beneficiaryList.get(i).getId() +" Validation null");
            }else{
                System.out.println("id: " + beneficiaryList.get(i).getId() +" Attempt: "+beneficiaryList.get(i).getBeneficiaryWalletValidation().getAttempt());
            }
        }

        WalletStatus walletStatus = new WalletStatus();
        walletStatus.setError(true);
        walletStatus.setValid(false);
        walletStatus.setResponse("ruinnig");

        return gson.toJson(walletStatus);
    }

    @GetMapping(value = "/ver")
    @ResponseBody
    public String checkSaveUpdate(){
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

    @GetMapping(value = "/login")
    public String view(){

        return "login";
    }

}
