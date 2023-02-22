package com.anunad.WalletVerification.dao;

import com.anunad.WalletVerification.model.WalletValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author rasel
 */
@Repository
public interface WalletValidationRepo extends JpaRepository<WalletValidation, Integer> {

    /**
     *
     * @param beneficiaryId
     * @param mobileBankingProviderId
     * @param accountNo
     * @return
     */
    @Query(value = "SELECT * FROM wallet_validation val WHERE  val.beneficiary_id = ?1 and val.mobile_bank_provider_id=?2 and val.account_no=?3", nativeQuery = true)
    WalletValidation findByBenAccountTypeAccountNo(int beneficiaryId, int mobileBankingProviderId, String accountNo);

    /**
     *
     * @param beneficiaryId
     * @param mobileBankingProviderId
     * @param accountNo
     * @param isVerified
     * @return
     */
    @Transactional
    @Modifying
    @Query(value="INSERT INTO wallet_validation ( beneficiary_id, mobile_bank_provider_id, account_no, is_verified) " +
            " VALUES ( :benId, :mfs, :account, :verify) ON DUPLICATE KEY UPDATE " +
            " attempt = attempt + 1, is_verified=:verify",  nativeQuery = true)
    int updateOrInsertWalletValidation(@Param("benId") int beneficiaryId, @Param("mfs") int mobileBankingProviderId,
                                       @Param("account") String accountNo, @Param("verify") int isVerified);
}
