package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.model.AccountType;

import java.util.List;

/**
 *
 * @author rasel
 */
public interface AccountTypeService {

    /**
     *
     * @return
     */
    List<AccountType> fetchAccountTypeList();
}
