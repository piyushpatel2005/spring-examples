package com.piyushpatel2005.ls.web.controller;

 
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.model.Task;
import com.piyushpatel2005.ls.service.IProjectService;
import com.piyushpatel2005.ls.web.dto.ProjectDto;
import com.piyushpatel2005.ls.web.dto.TaskDto;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    
    private IProjectService projectService;
    
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/{id}")
    public ProjectDto findById(@PathVariable Long id) {
        Project entity = projectService.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        return convertToDto(entity);
    }

    @PostMapping
    public void create(@RequestBody ProjectDto newProject) {
        Project entity = convertToEntity(newProject);
        this.projectService.save(entity);
    }

    
    protected ProjectDto convertToDto(Project entity) {
        ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getDateCreated());
        dto.setTasks(entity.getTasks()
            .stream()
            .map(t -> convertTaskToDto(t))
            .collect(Collectors.toSet()));
        
        return dto;
    }
    
    protected Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.getName(), dto.getDateCreated());
        if(!StringUtils.isEmpty(dto.getId())) {
            project.setId(dto.getId());
        }
        return project;
    }
    
    protected TaskDto convertTaskToDto(Task entity) {
        TaskDto dto = new TaskDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getDateCreated(), entity.getDueDate(), entity.getStatus());
        return dto;
    }
    
    protected Task convertTaskToEntity(TaskDto dto) {
        Task task = new Task(dto.getName(), dto.getDescription(), dto.getDateCreated(), dto.getDueDate(), dto.getStatus());
        if (!StringUtils.isEmpty(dto.getId())) {
            task.setId(dto.getId());
        }
        
        return task;
    }
}
