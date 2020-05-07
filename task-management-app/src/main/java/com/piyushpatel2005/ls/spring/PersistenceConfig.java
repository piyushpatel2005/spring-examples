package com.piyushpatel2005.ls.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.piyushpatel2005.ls.persistence.repository.impl.ProjectRepositoryImpl;

@Configuration
public class PersistenceConfig {

    @Bean
    public ProjectRepositoryImpl projectRepository() {
        return new ProjectRepositoryImpl();
    }
}
