package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.model.WalletValidation;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author rasel
 */
public interface WalletValidationService {

    /**
     *
     * @param walletValidation
     * @return
     */
    boolean save(WalletValidation walletValidation);

    /**
     *
     * @param walletValidationList
     * @return
     */
    boolean saveAll(List<WalletValidation> walletValidationList);

    /**
     *
     * @param id
     * @return
     */
    WalletValidation findById(int id);

    /**
     *
     * @param ids
     * @return
     */
    List<WalletValidation> findAllByIds(List<Integer> ids);

    /**
     *
     * @param beneficiaryId
     * @param mobileBankingProviderId
     * @param accountNo
     * @return
     */
    WalletValidation findByBenAccountTypeAccountNo(int beneficiaryId, int mobileBankingProviderId, String accountNo);

    /**
     *
     * @param beneficiaryId
     * @param mobileBankingProviderId
     * @param accountNo
     * @param isVerified
     * @return
     */
    int updateOrInsertWalletValidation(@Param("benId") int beneficiaryId, @Param("mfs") int mobileBankingProviderId,
                                       @Param("account") String accountNo, @Param("verify") int isVerified);
}
