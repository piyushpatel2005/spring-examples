package com.piyushpatel2005.ls;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class LsApplication {

//    @Autowired
//    IProjectService projectService;
    
    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);
    }
    
    @PostConstruct
    public void postConstruct() {
//        projectService.save(new Project(1L, "My First Project", LocalDate.now()));
    }

}
