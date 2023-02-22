package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.dao.BeneficiaryWalletValidationRepository;
import com.anunad.WalletVerification.model.BeneficiaryWalletValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author rasel
 */
@Service
public class BeneficiaryWalletValidationServiceImpl implements BeneficiaryWalletValidationService {

    @Autowired
    BeneficiaryWalletValidationRepository beneficiaryWalletValidationRepository;

    /**
     *
     * @param beneficiaryWalletValidation
     * @return
     */
    @Override
    public boolean save(BeneficiaryWalletValidation beneficiaryWalletValidation) {
        beneficiaryWalletValidationRepository.save(beneficiaryWalletValidation);
        return true;
    }

    /**
     *
     * @param beneficiaryWalletValidations
     * @return
     */
    @Override
    public boolean saveAll(List<BeneficiaryWalletValidation> beneficiaryWalletValidations) {
        beneficiaryWalletValidationRepository.saveAll(beneficiaryWalletValidations);
        return true;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public BeneficiaryWalletValidation findById(int id) {
        Optional<BeneficiaryWalletValidation> optional = beneficiaryWalletValidationRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    /**
     *
     * @param ids
     * @return
     */
    @Override
    public List<BeneficiaryWalletValidation> findAllByIds(List<Integer> ids) {
        beneficiaryWalletValidationRepository.findAllById(ids);
        return null;
    }
}
