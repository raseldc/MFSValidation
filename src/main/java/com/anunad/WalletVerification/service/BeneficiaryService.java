package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.model.Beneficiary;

import java.util.List;

/**
 *
 * @author rasel
 */
public interface BeneficiaryService {

    /**
     *
     * @param id
     * @return
     */
    List<Beneficiary> findBeneficiariesById(Integer id);

    /**
     *
     * @return
     */
    List<Beneficiary> fetchBeneficiaryList();

    /**
     *
     * @param mfsId
     * @return
     */
    List<Beneficiary> findBeneficiariesByMFSId(Integer mfsId);

    /**
     *
     * @param mfsId
     * @param verificationStatus
     * @return
     */
    List<Beneficiary> findBeneficiariesByMfsIdAndStatus(Integer mfsId, int verificationStatus);

    /**
     *
     * @param mfsId
     * @param verificationStatus
     * @param limit
     * @return
     */
    List<Beneficiary> findBeneficiariesByMfsIdAndStatusAndLimit(Integer mfsId, int verificationStatus, int limit);

    /**
     *
     * @param verificationStatus
     * @return
     */
    List<Beneficiary> findBeneficiariesByStatus(int verificationStatus);

    /**
     *
     * @param verificationStatus
     * @param limit
     * @return
     */
    List<Beneficiary> findBeneficiariesByStatusAndLimit(int verificationStatus, int limit);

    /**
     *
     * @param verificationStatus
     * @param limit
     * @return
     */
    List<Beneficiary> findBeneficiariesByStatusAndLimitAttempt(int verificationStatus, int limit);

    /**
     *
     * @param verificationStatus
     * @param limit
     * @return
     */
    List<Beneficiary> findBenForWalletValidation(int verificationStatus, int limit);

    /**
     *
     * @param idList
     * @param status
     * @return
     */
    int setAccountVerificationStatus(List<Integer> idList, int status);

    /**
     *
     * @param id
     * @param status
     * @return
     */
    int setAccountVerificationStatus(Integer id, int status);

}
