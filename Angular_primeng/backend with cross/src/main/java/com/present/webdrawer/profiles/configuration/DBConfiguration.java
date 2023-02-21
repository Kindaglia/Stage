package com.present.webdrawer.profiles.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import lombok.extern.java.Log;

@Log
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Profile("local")
    @Bean
    public void localDatabaseConnection() {
        log.info("DB Connection for local - h2");
        log.info(driverClassName);
        log.info(url);
    }

    @Profile("dev")
    @Bean
    public void devDatabaseConnection() {
        log.info("DB Connection for dev - mysql");
        log.info(driverClassName);
        log.info(url);
    }

}
