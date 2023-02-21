package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.dao.BeneficiaryRepository;
import com.anunad.WalletVerification.model.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Override
    public List<Beneficiary> fetchBeneficiaryList() {
        return beneficiaryRepository.findAll();
    }

    @Override
    public List<Beneficiary> findBeneficiariesByMFSId(Integer mfsId) {
        return beneficiaryRepository.findBeneficiariesByMFSId(mfsId);
    }

    @Override
    public List<Beneficiary> findBeneficiariesByMfsIdAndStatus(Integer mfsId, int verificationStatus) {
        return beneficiaryRepository.findBeneficiariesByMfsIdAndStatus(mfsId, verificationStatus);
    }

    @Override
    public List<Beneficiary> findBeneficiariesByMfsIdAndStatusAndLimit(Integer mfsId, int verificationStatus, int limit) {
        return beneficiaryRepository.findBeneficiariesByMfsIdAndStatusAndLimit(mfsId, verificationStatus, limit);
    }

    @Override
    public List<Beneficiary> findBeneficiariesById(Integer id) {
        return beneficiaryRepository.findBeneficiariesById(id);
    }

    @Override
    public List<Beneficiary> findBeneficiariesByStatus(int verificationStatus) {
        return beneficiaryRepository.findBeneficiariesByStatus(verificationStatus);
    }

    @Override
    public List<Beneficiary> findBeneficiariesByStatusAndLimit(int verificationStatus, int limit) {
        return beneficiaryRepository.findBeneficiariesByStatusAndLimit(verificationStatus, limit);
    }

    @Override
    public List<Beneficiary> findBeneficiariesByStatusAndLimitAttempt(int verificationStatus, int limit) {
        return beneficiaryRepository.findBeneficiariesByStatusAndLimitAttempt(verificationStatus, limit);
    }

    @Override
    public List<Beneficiary> findBenForWalletValidation(int verificationStatus, int limit) {
        return beneficiaryRepository.findBenForWalletValidation(verificationStatus, limit);
    }

    @Override
    public int setAccountVerificationStatus(List<Integer> idList, int status) {
        return beneficiaryRepository.setAccountVerificationStatus(idList, status);
    }

    @Override
    public int setAccountVerificationStatus(Integer id, int status) {
        return beneficiaryRepository.setAccountVerificationStatus(id, status);
    }
}
