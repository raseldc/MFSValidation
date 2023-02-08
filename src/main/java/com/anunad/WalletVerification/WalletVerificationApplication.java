package com.anunad.WalletVerification;

import com.anunad.WalletVerification.job.CreateQuartzJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.anunad.WalletVerification.*")
@EnableScheduling
public class WalletVerificationApplication {

	public static void main(String[] args) {

		SpringApplication.run(WalletVerificationApplication.class, args);

	}

}
