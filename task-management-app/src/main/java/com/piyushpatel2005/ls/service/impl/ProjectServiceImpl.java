package com.piyushpatel2005.ls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.repository.IProjectRepository;
import com.piyushpatel2005.ls.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;
    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    public ProjectServiceImpl(IProjectRepository projectRepo) {
        super();
        this.projectRepository = projectRepo;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project Service >> Finding project By Id {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Project Service >> Saving Project {}", project);
        return projectRepository.save(project);
    }

}
