package com.piyushpatel2005.ls;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class LsApp {

    private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);
    
    @Value("${additional.info}")
    private String additional;
    
    public static void main(String[] args) {
        SpringApplication.run(LsApp.class, args);
    }
    
    @PostConstruct
    public void postConstruct() {
        LOG.info("Addditional Property {}", additional);
    }
    
}
