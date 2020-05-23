package com.piyushpatel2005.ls.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.model.Task;
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
        if (StringUtils.isEmpty(project.getId())) {
            project.setDateCreated(LocalDate.now());
        }
        return projectRepository.save(project);
    }
    
    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }
    
    @Override
    public Project addTasks(Project project, List<Task> tasks) {
        project.getTasks().addAll(tasks.stream().filter(t -> !StringUtils.isEmpty(t.getName())).collect(Collectors.toList()));
        
        projectRepository.save(project);
        return project;
    }

}
