package com.piyushpatel2005.ls.service;

import java.util.List;
import java.util.Optional;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.model.Task;

public interface IProjectService {

	Optional<Project> findById(Long id);
	
	Project save(Project project);
	
	Iterable<Project> findAll();
	
	void delete(Long id);
	
	Iterable<Project> findByName(String name);
	
	Project addTasks(Project project, List<Task> tasks);
}
