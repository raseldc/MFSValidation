package com.anunad.WalletVerification.dao;

import com.anunad.WalletVerification.model.BeneficiaryWalletValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BeneficiaryWalletValidationRepository extends JpaRepository<BeneficiaryWalletValidation, Integer> {


}
