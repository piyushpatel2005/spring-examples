package com.piyushpatel2005.ls.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.piyushpatel2005.ls.persistence.model.Project;


public interface IProjectRepository extends CrudRepository<Project, Long> {

}
