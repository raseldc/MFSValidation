package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.model.BeneficiaryWalletValidation;

import java.util.List;

public interface BeneficiaryWalletValidationService {
    boolean save(BeneficiaryWalletValidation beneficiaryWalletValidation);
    boolean saveAll(List<BeneficiaryWalletValidation> beneficiaryWalletValidations);

    BeneficiaryWalletValidation findById(int id);
    List<BeneficiaryWalletValidation> findAllByIds(List<Integer> ids);

}
