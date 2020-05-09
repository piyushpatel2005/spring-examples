package com.piyushpatel2005.ls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.piyushpatel2005.ls.service.IProjectService;
import com.piyushpatel2005.ls.service.impl.ProjectServiceImplSetterInjection;

@Configuration
public class LsAppConfig {

    @Bean
    public IProjectService projectServiceImplSetterInjection() {
        return new ProjectServiceImplSetterInjection();
    }
}
