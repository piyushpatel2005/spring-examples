package com.piyushpatel2005.ls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.piyushpatel2005.ls.persistence.repository.IProjectRepository;
import com.piyushpatel2005.ls.persistence.repository.impl.ProjectRepositoryImpl;

@Configuration
public class LsAppConfig {

//    @Bean
//    @Scope("singleton")
//    public IProjectService projectServiceImplSetterInjection() {
//        return new ProjectServiceImplSetterInjection();
//    }
    
    @Bean
    @Scope("singleton")
    public IProjectRepository prototypeBean() {
        return new ProjectRepositoryImpl();
    }
    
}
