package com.coindesk;

import com.coindesk.model.Customer;
import com.coindesk.repository.CustomerRepository;
import com.initialization.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoinDeskApplication {

    private static final Logger log = LoggerFactory.getLogger(CoinDeskApplication.class);

    public static void main(String[] agrs){
        SpringApplication.run(CoinDeskApplication.class, agrs);
    }


    /*
    *   chia lai domain
    *   chia profiles lai trong application cho 3 loai: dev, prod, test
    *   tao data migration liquilbase de generate data khong can viet trong ham commandline https://www.roytuts.com/evolving-database-using-spring-boot-liquibase/
    *  */
}
