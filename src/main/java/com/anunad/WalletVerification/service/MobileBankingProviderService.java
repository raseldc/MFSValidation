package com.anunad.WalletVerification.service;


import com.anunad.WalletVerification.model.MobileBankingProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MobileBankingProviderService {

    List<MobileBankingProvider> fetchMobileBankingProviderList();

    MobileBankingProvider findProvideById(Integer id);

    MobileBankingProvider findProvideByName(String name);


}
