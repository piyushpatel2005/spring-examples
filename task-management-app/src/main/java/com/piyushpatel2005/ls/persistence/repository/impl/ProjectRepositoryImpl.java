package com.piyushpatel2005.ls.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.repository.IProjectRepository;


@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    @Value("${project.prefix}")
    private String prefix;
    
    @Value("${project.suffix}")
    private Integer suffix;
        
    List<Project> projects = new ArrayList<>();


    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() ==id).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        
        updateInternalId(project);
        
        if(existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            projects.add(project);
        }
        return project;
    }
    
    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId() + suffix);
    }

}
