package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.model.BeneficiaryWalletValidation;

import java.util.List;

/**
 *
 * @author rasel
 */
public interface BeneficiaryWalletValidationService {

    /**
     *
     * @param beneficiaryWalletValidation
     * @return
     */
    boolean save(BeneficiaryWalletValidation beneficiaryWalletValidation);

    /**
     *
     * @param beneficiaryWalletValidations
     * @return
     */
    boolean saveAll(List<BeneficiaryWalletValidation> beneficiaryWalletValidations);

    /**
     *
     * @param id
     * @return
     */
    BeneficiaryWalletValidation findById(int id);

    /**
     *
     * @param ids
     * @return
     */
    List<BeneficiaryWalletValidation> findAllByIds(List<Integer> ids);

}
