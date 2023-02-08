package com.anunad.WalletVerification.dao;

import com.anunad.WalletVerification.model.MobileBankingProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MobileBankingProviderRepository extends JpaRepository<MobileBankingProvider, Integer> {

    @Query(value = "SELECT * FROM mobile_banking_provider WHERE id = ?1", nativeQuery = true)
    MobileBankingProvider findProvideById(Integer id);

    @Query(value = "SELECT * FROM mobile_banking_provider WHERE  name_in_english = ?1", nativeQuery = true)
    MobileBankingProvider findProvideByName(String name);
}
