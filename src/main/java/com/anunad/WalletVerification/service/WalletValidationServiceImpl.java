package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.dao.WalletValidationRepo;
import com.anunad.WalletVerification.model.WalletValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author rasel
 */
@Service
public class WalletValidationServiceImpl implements WalletValidationService {
    @Autowired
    WalletValidationRepo walletValidationRepo;

    /**
     *
     * @param walletValidation
     * @return
     */
    @Override
    public boolean save(WalletValidation walletValidation) {
        walletValidationRepo.save(walletValidation);
        return true;
    }

    /**
     *
     * @param walletValidationList
     * @return
     */
    @Override
    public boolean saveAll(List<WalletValidation> walletValidationList) {
        walletValidationRepo.saveAll(walletValidationList);
        return true;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public WalletValidation findById(int id) {
        Optional<WalletValidation> optional = walletValidationRepo.findById(id);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    /**
     *
     * @param ids
     * @return
     */
    @Override
    public List<WalletValidation> findAllByIds(List<Integer> ids) {
        walletValidationRepo.findAllById(ids);
        return null;
    }

    /**
     *
     * @param beneficiaryId
     * @param mobileBankingProviderId
     * @param accountNo
     * @return
     */
    @Override
    public WalletValidation findByBenAccountTypeAccountNo(int beneficiaryId, int mobileBankingProviderId, String accountNo) {
        return walletValidationRepo.findByBenAccountTypeAccountNo(beneficiaryId, mobileBankingProviderId, accountNo);
    }

    /**
     *
     * @param beneficiaryId
     * @param mobileBankingProviderId
     * @param accountNo
     * @param isVerified
     * @return
     */
    @Override
    public int updateOrInsertWalletValidation(int beneficiaryId, int mobileBankingProviderId, String accountNo, int isVerified) {
        return walletValidationRepo.updateOrInsertWalletValidation(beneficiaryId, mobileBankingProviderId, accountNo, isVerified);
    }
}
