package com.piyushpatel2005.ls.service.impl;

import java.util.List;
import java.util.Optional;

import com.piyushpatel2005.ls.persistence.model.Task;
import com.piyushpatel2005.ls.persistence.repository.ITaskRepository;
import com.piyushpatel2005.ls.service.ITaskService;

public class TaskServiceImpl implements ITaskService {
    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    
    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task project) {
        return taskRepository.save(project);
    }
    
    @Override
    public Iterable<Task> saveAll(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

}
