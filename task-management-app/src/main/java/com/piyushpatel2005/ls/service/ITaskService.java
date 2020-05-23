package com.piyushpatel2005.ls.service;

import java.util.Optional;

import com.piyushpatel2005.ls.persistence.model.Task;

public interface ITaskService {

    Optional<Task> findById(Long id);
    
    Task save(Task project);
}