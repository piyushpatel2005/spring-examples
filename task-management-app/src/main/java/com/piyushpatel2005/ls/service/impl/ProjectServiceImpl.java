package com.piyushpatel2005.ls.service.impl;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.repository.IProjectRepository;
import com.piyushpatel2005.ls.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private IProjectRepository projectRepository;
	
	@Autowired
	private IProjectRepository projectRepository2; 
	
	public ProjectServiceImpl(IProjectRepository projectRepo) {
		super();
		this.projectRepository = projectRepo;
	}

	@Override
	public Optional<Project> findById(Long id) {
		return projectRepository.findById(id);
	}

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}
	
	@PostConstruct
	public void after() {
	    
	}
}
