package com.anunad.WalletVerification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author rasel
 */
@SpringBootApplication
@ComponentScan("com.anunad.WalletVerification.*")
@EnableScheduling
public class WalletVerificationApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

		SpringApplication.run(WalletVerificationApplication.class, args);

	}

}
