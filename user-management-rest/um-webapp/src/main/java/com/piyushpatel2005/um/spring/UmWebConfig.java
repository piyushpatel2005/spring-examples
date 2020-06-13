package com.piyushpatel2005.um.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "com.piyushpatel2005.um.web" })
@EnableWebMvc
public class UmWebConfig {

  public UmWebConfig() {
    super();
  }
}
