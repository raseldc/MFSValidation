package com.anunad.WalletVerification.job;

import com.anunad.WalletVerification.service.ValidationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author rasel
 */
@Component
public class ScheduledTasks {

    //private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    ValidationService validationService;

//    @Scheduled(fixedRate = 2000)

    /**
     *
     */
    public void scheduleTaskWithFixedRate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        //System.out.println(" Job running .... .... "+formatter.format(date));
    }

    /**
     *
     */
    public void scheduleTaskWithFixedDelay() {
    }

    /**
     *
     */
    public void scheduleTaskWithInitialDelay() {
    }

    // run every 10 sec after 0:0 hour theke 1:0 hour porjonto 

    /**
     *
     */
    @Scheduled(cron = "*/10 * 0-1 * * ?")
    public void scheduleTaskWithCronExpression() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(" Job running .... .... at ... " + formatter.format(date));
        validationService.validate(10);
    }
}
