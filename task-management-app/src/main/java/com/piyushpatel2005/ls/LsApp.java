package com.piyushpatel2005.ls;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.service.IProjectService;

@SpringBootApplication()
public class LsApp {

    @Autowired
    IProjectService projectService;
    
    public static void main(String[] args) {
        SpringApplication.run(LsApp.class, args);
    }
    
    @PostConstruct
    public void postConstruct() {

        Project project = new Project("My First project", LocalDate.now());
        projectService.save(project);
        
        Optional<Project> optionalProject = projectService.findById(1L);
        optionalProject.ifPresent(System.out::println);
    }

}
