package com.piyushpatel2005.ls.persistence.model;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanB {

    private static Logger log = LoggerFactory.getLogger(BeanB.class);
    
    public void initialize() {
        log.info("Custom initializer is called.");
    }
    
    @PostConstruct
    public void postConstruct() {
        log.info("@PostConstruct method is called.");
    }
}
