package com.anunad.WalletVerification.dao;

import com.anunad.WalletVerification.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author rasel
 */
@Repository
public interface  AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
