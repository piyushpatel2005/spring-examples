package com.piyushpatel2005.ls.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.repository.IProjectRepository;
import com.piyushpatel2005.ls.service.IProjectService;

public class ProjectServiceImplSetterInjection implements IProjectService {

    private IProjectRepository projectRepository;
    
    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
    
    @Autowired
    @Qualifier("projectRepositoryImpl2")
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

}
