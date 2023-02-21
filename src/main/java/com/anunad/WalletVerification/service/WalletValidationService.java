package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.model.WalletValidation;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WalletValidationService {

    boolean save(WalletValidation walletValidation);
    boolean saveAll(List<WalletValidation> walletValidationList);

    WalletValidation findById(int id);
    List<WalletValidation> findAllByIds(List<Integer> ids);
    WalletValidation findByBenAccountTypeAccountNo(int beneficiaryId, int mobileBankingProviderId, String accountNo);

    int updateOrInsertWalletValidation(@Param("benId") int beneficiaryId, @Param("mfs") int mobileBankingProviderId,
                                       @Param("account") String accountNo, @Param("verify") int isVerified);
}
