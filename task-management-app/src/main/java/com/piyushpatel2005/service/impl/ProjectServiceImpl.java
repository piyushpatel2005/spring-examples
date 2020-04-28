package com.piyushpatel2005.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyushpatel2005.persistence.model.Project;
import com.piyushpatel2005.persistence.repository.IProjectRepository;
import com.piyushpatel2005.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	 private IProjectRepository projectRepo;
	
	public ProjectServiceImpl(IProjectRepository projectRepo) {
		super();
		this.projectRepo = projectRepo;
	}

	@Override
	public Optional<Project> findById(Long id) {
		return projectRepo.findById(id);
	}

	@Override
	public Project save(Project project) {
		return projectRepo.save(project);
	}
}
