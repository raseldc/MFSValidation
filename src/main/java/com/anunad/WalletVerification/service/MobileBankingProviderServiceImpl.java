package com.anunad.WalletVerification.service;

import com.anunad.WalletVerification.dao.MobileBankingProviderRepository;
import com.anunad.WalletVerification.model.MobileBankingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author rasel
 */
@Service
public class MobileBankingProviderServiceImpl implements MobileBankingProviderService {

    @Autowired
    MobileBankingProviderRepository mobileBankingProviderRepository;

    /**
     *
     * @return
     */
    @Override
    public List<MobileBankingProvider> fetchMobileBankingProviderList() {
        return mobileBankingProviderRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public MobileBankingProvider findProvideById(Integer id) {
        return mobileBankingProviderRepository.findProvideById(id);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public MobileBankingProvider findProvideByName(String name) {
        return mobileBankingProviderRepository.findProvideByName(name);
    }
}
