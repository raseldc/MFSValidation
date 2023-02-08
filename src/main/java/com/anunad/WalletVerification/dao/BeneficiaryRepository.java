package com.anunad.WalletVerification.dao;

import com.anunad.WalletVerification.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

    @Query(value = "SELECT * FROM beneficiary WHERE  beneficiary.Id = ?1", nativeQuery = true)
    List<Beneficiary> findBeneficiariesById(Integer id);

    @Query(value = "SELECT * FROM beneficiary WHERE  mobile_banking_provider_id = ?1", nativeQuery = true)
    List<Beneficiary> findBeneficiariesByMFSId(Integer mfsId);

    @Query(value = "SELECT * FROM beneficiary WHERE  mobile_banking_provider_id = ?1 and is_account_verfied = ?2", nativeQuery = true)
    List<Beneficiary> findBeneficiariesByMfsIdAndStatus(Integer mfsId, int verificationStatus);

    @Query(value = "SELECT * FROM beneficiary WHERE  is_account_verfied = ?1", nativeQuery = true)
    List<Beneficiary> findBeneficiariesByStatus(int verificationStatus);

    @Query(value = "SELECT * FROM beneficiary WHERE  mobile_banking_provider_id = ?1 and is_account_verfied = ?2 order by Id limit ?3", nativeQuery = true)
    List<Beneficiary> findBeneficiariesByMfsIdAndStatusAndLimit(Integer mfsId, int verificationStatus, int limit);


    @Query(value = "SELECT * FROM beneficiary WHERE mobile_banking_provider_id = 30 and is_account_verfied = ?1 order by Id limit ?2", nativeQuery = true)
    List<Beneficiary> findBeneficiariesByStatusAndLimit(int verificationStatus, int limit);



    @Query(value = "SELECT ben.* FROM imlma.beneficiary ben LEFT JOIN imlma.beneficiary_wallet_validation val ON ben.id = val.id " +
            " WHERE ben.mobile_banking_provider_id = 30 and ben.is_account_verfied = ?1  and IFNULL(val.attempt,0) < 5 " +
            " and DATE_ADD(IFNULL(wv.modified_time, '2022-01-01'), INTERVAL 5 HOUR) < NOW() " +
            " order by ben.Id limit ?2", nativeQuery = true)
    List<Beneficiary> findBeneficiariesByStatusAndLimitAttempt(int verificationStatus, int limit);

    @Transactional
    @Modifying
    @Query(value="update beneficiary set is_account_verfied = :status where id in (:ids)",  nativeQuery = true)
    int setAccountVerificationStatus(@Param("ids") List<Integer> ids, @Param("status") int status);

    @Transactional
    @Modifying
    @Query(value="update beneficiary set is_account_verfied = :status where id = :id",  nativeQuery = true)
    int setAccountVerificationStatus(@Param("id") Integer id, @Param("status") int status);
}
