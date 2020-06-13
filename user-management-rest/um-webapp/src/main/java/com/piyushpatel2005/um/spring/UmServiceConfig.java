package com.piyushpatel2005.um.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.piyushpatel2005.um.service" })
public class UmServiceConfig {

  public UmServiceConfig() {
    super();
  }
}
