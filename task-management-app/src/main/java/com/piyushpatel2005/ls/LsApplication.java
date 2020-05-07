package com.piyushpatel2005.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.piyushpatel2005.ls.persistence")
public class LsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsApplication.class, args);
	}

}
