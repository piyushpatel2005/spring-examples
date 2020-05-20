package com.piyushpatel2005.ls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piyushpatel2005.ls.service.IProjectService;

@SpringBootApplication()
public class LsApp {

    @Autowired
    IProjectService projectService;
    
    public static void main(String[] args) {
        SpringApplication.run(LsApp.class, args);
    }
    
}
