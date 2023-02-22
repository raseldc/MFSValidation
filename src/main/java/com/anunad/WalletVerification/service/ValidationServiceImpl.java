package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.helper.WalletStatus;
import com.anunad.WalletVerification.helper.Nagad.NagadVerificationHelper;
import com.anunad.WalletVerification.helper.Upay.UpayVerificationHelper;
import com.anunad.WalletVerification.model.Beneficiary;
import com.anunad.WalletVerification.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rasel
 */
@Service
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private MobileBankingProviderService mobileBankingProviderService;
    @Autowired
    private WalletValidationService walletValidationService;

    /**
     *
     * @param limit
     * @return
     */
    @Override
    public boolean validate(int limit) {

        List<Beneficiary> beneficiaryList = beneficiaryService.findBenForWalletValidation(Constant.STATUS_DEFAULT, limit);
        List<Integer> idList = new ArrayList<>();

        idList = beneficiaryList.stream().map(a -> {
            return a.getId();
        }).collect(Collectors.toList());

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
        return true;
    }
}
