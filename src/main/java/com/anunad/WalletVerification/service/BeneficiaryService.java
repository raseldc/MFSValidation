package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.model.Beneficiary;

import java.util.List;

public interface BeneficiaryService {

    List<Beneficiary> findBeneficiariesById(Integer id);

    List<Beneficiary> fetchBeneficiaryList();

    List<Beneficiary> findBeneficiariesByMFSId(Integer mfsId);

    List<Beneficiary> findBeneficiariesByMfsIdAndStatus(Integer mfsId, int verificationStatus);

    List<Beneficiary> findBeneficiariesByMfsIdAndStatusAndLimit(Integer mfsId, int verificationStatus, int limit);

    List<Beneficiary> findBeneficiariesByStatus(int verificationStatus);

    List<Beneficiary> findBeneficiariesByStatusAndLimit(int verificationStatus, int limit);

    List<Beneficiary> findBeneficiariesByStatusAndLimitAttempt(int verificationStatus, int limit);



    int setAccountVerificationStatus(List<Integer> idList, int status);

    int setAccountVerificationStatus(Integer id, int status);

}
