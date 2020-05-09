package com.piyushpatel2005.ls;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.service.IProjectService;

@SpringBootApplication()
public class LsApplication {

    @Autowired
    IProjectService projectService;
    
    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);
    }
    
    @PostConstruct
    public void postConstruct() {
        projectService.save(new Project(1L, "My First Project", LocalDate.now()));
    }

}
