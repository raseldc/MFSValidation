package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.dao.BeneficiaryWalletValidationRepository;
import com.anunad.WalletVerification.model.BeneficiaryWalletValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryWalletValidationServiceImpl implements BeneficiaryWalletValidationService {

    @Autowired
    BeneficiaryWalletValidationRepository beneficiaryWalletValidationRepository;

    @Override
    public boolean save(BeneficiaryWalletValidation beneficiaryWalletValidation) {
        beneficiaryWalletValidationRepository.save(beneficiaryWalletValidation);
        return true;
    }

    @Override
    public boolean saveAll(List<BeneficiaryWalletValidation> beneficiaryWalletValidations) {
        beneficiaryWalletValidationRepository.saveAll(beneficiaryWalletValidations);
        return true;
    }

    @Override
    public BeneficiaryWalletValidation findById(int id) {
        Optional<BeneficiaryWalletValidation> optional = beneficiaryWalletValidationRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    @Override
    public List<BeneficiaryWalletValidation> findAllByIds(List<Integer> ids) {
        beneficiaryWalletValidationRepository.findAllById(ids);
        return null;
    }
}
