package com.piyushpatel2005.ls.persistence.repository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.time.LocalDate;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.piyushpatel2005.ls.persistence.model.Project;

//@Component
public class TestDataLoader implements ApplicationContextAware {

    
    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
    }
}
