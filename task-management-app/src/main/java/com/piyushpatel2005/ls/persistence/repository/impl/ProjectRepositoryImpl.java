package com.piyushpatel2005.ls.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.repository.IProjectRepository;


//@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

	List<Project> projects = new ArrayList<>();
	
	public ProjectRepositoryImpl() {
	    super();
	}
	
	@Override
	public Optional<Project> findById(Long id) {
		return projects.stream().filter(p -> p.getId() ==id).findFirst();
	}

	@Override
	public Project save(Project project) {
		Project existingProject = findById(project.getId()).orElse(null);
		if(existingProject == null) {
			projects.add(project);
		} else {
			projects.remove(existingProject);
			projects.add(project);
		}
		return project;
	}

}
