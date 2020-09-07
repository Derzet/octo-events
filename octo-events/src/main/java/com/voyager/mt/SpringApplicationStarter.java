package com.voyager.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@SpringBootApplication
@EnableTransactionManagement
@ConfigurationProperties
@ComponentScan
@EnableJpaRepositories
public class SpringApplicationStarter {

    public static void main(String[] args){
        SpringApplication.run(SpringApplicationStarter.class,args);
    }
}

