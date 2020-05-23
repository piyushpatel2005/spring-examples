package com.piyushpatel2005.ls.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.service.IProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    
    private IProjectService projectService;
    
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/{id}")
    public Project findById(@PathVariable Long id) {
        return projectService.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public void create(@RequestBody Project newProject) {
        this.projectService.save(newProject);
    }
}
