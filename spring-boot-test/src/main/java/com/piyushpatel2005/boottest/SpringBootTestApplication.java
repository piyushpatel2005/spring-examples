package com.piyushpatel2005.boottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestApplication {

	private final static Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

	public static void main(String[] args) {
		log.debug("Hello logger");

		SpringApplication.run(
			SpringBootTestApplication.class, args);
	}

}
