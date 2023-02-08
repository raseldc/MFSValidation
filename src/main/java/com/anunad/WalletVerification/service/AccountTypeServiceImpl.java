package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.dao.AccountTypeRepository;
import com.anunad.WalletVerification.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountType> fetchAccountTypeList() {
        return (List<AccountType>)
                accountTypeRepository.findAll();
    }
}
