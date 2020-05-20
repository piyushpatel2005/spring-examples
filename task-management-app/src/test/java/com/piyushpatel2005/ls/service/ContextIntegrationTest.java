package com.piyushpatel2005.ls.service;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class ContextIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Test
    public void whenContextIsLoaded1_thenNoExceptions() {
        System.out.println();
    }
    
    @Test
    public void whenContextIsLoaded2_thenNoExceptions() {
        System.out.println();
    }
}
