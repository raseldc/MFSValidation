package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.helper.WalletStatus;
import com.anunad.WalletVerification.helper.Nagad.NagadVerificationHelper;
import com.anunad.WalletVerification.model.Beneficiary;
import com.anunad.WalletVerification.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private MobileBankingProviderService mobileBankingProviderService;

    @Override
    public boolean validate(int limit) {

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
            }else if(walletStatus.isValid()){
                successList.add(temp.getId());
            }else{
                failedList.add(temp.getId());
            }
        }
        beneficiaryService.setAccountVerificationStatus(successList, Constant.STATUS_SUCCESS);
        beneficiaryService.setAccountVerificationStatus(failedList, Constant.STATUS_FAILED);
        beneficiaryService.setAccountVerificationStatus(triedList, Constant.STATUS_DEFAULT);
        return true;
    }
}
