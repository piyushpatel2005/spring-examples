package com.piyushpatel2005.service;

import java.util.Optional;

import com.piyushpatel2005.persistence.model.Project;

public interface IProjectService {

	Optional<Project> findById(Long id);
	
	Project save(Project project);
}
