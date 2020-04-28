package com.piyushpatel2005.persistence.repository;

import java.util.Optional;

import com.piyushpatel2005.persistence.model.Project;

public interface IProjectRepository {

	Optional<Project> findById(Long id);
	
	Project save(Project project);
}
