package com.piyushpatel2005.um.spring;

import com.piyushpatel2005.um.persistence.setup.MyApplicationContextInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
  UmContextConfig.class,
  UmPersistenceJpaConfig.class,
  UmServiceConfig.class,
  UmWebConfig.class
})
public class UmApp {

  public static void main(final String[] args) {
    new SpringApplicationBuilder(UmApp.class).initializers(new MyApplicationContextInitializer())
      .listeners()
      .run(args);
  }
}
