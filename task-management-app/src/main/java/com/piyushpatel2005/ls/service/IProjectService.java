package com.piyushpatel2005.ls.service;

import java.util.Optional;

import com.piyushpatel2005.ls.persistence.model.Project;

public interface IProjectService {

	Optional<Project> findById(Long id);
	
	Project save(Project project);
}
