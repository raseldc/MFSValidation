package com.anunad.WalletVerification.service;


import com.anunad.WalletVerification.model.MobileBankingProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author rasel
 */
public interface MobileBankingProviderService {

    /**
     *
     * @return
     */
    List<MobileBankingProvider> fetchMobileBankingProviderList();

    /**
     *
     * @param id
     * @return
     */
    MobileBankingProvider findProvideById(Integer id);

    /**
     *
     * @param name
     * @return
     */
    MobileBankingProvider findProvideByName(String name);


}
