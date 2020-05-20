package com.piyushpatel2005.ls;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = LsApp.class)
@TestPropertySource(locations = "classpath:test.properties")
public class TestPropertySourceTest {
    
    @Value("${testProperty}")
    private String testProperty;
    
    @Value("${additional.info}")
    private String additional;

    @Test
    public void whenTestPropertySource_thenValuesRetrieved() {
        assertEquals("Test Property Value", testProperty);
    }
    
    @Test
    @Disabled("Added only as an intermediate step for understanding, to make this run - comment additional.info from test.properties")
    public void whenPropertyDefinedInMain_thenValuesRetrieved() {
        assertEquals("Additional info", additional);
    }
    
    @Test
    public void givenSameProperty_thenHigherPriority() {
        assertEquals("Additional Info from Test", additional);
    }
}
