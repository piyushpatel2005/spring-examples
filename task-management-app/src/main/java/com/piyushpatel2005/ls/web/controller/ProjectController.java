package com.piyushpatel2005.ls.web.controller;

 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.piyushpatel2005.ls.persistence.model.Project;
import com.piyushpatel2005.ls.persistence.model.Task;
import com.piyushpatel2005.ls.service.IProjectService;
import com.piyushpatel2005.ls.web.dto.ProjectDto;
import com.piyushpatel2005.ls.web.dto.TaskDto;

@RestController
//@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
    
    private IProjectService projectService;
    
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/{id}")
    public ProjectDto findById(@PathVariable Long id) {
        Project entity = projectService.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));
        
        return convertToDto(entity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto create(@RequestBody ProjectDto newProject) {
        Project entity = convertToEntity(newProject);
        return this.convertToDto(projectService.save(entity));
    }
    
    @GetMapping
    public Collection<ProjectDto> findProjects(@RequestParam(name = "name", defaultValue = "") String name) {
        Iterable<Project> allProjects = this.projectService.findByName(name);
        List<ProjectDto> projectDtos = new ArrayList<>();
        allProjects.forEach(p -> projectDtos.add(convertToDto(p)));
        return projectDtos;
    }
    
    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto updatedProject) {
        Project projectEntity = convertToEntity(updatedProject);
        return this.convertToDto(this.projectService.save(projectEntity));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
    }
    
//    @GetMapping
//    public String getProjects(Model model) {
//        Iterable<Project> projects = projectService.findAll();
//        List<ProjectDto> projectDtos = new ArrayList<>();
//        projects.forEach(p -> projectDtos.add(convertToDto(p)));
//        model.addAttribute("projects", projectDtos);
//        return "projects";
//    }
//
//    @GetMapping("/new")
//    public String newProject(Model model) {
//        model.addAttribute("project", new ProjectDto());
//        return "new-project";
//    }
//    
//    @GetMapping("/{id}")
//    public String getProject(@PathVariable Long id, Model model) {
//        Project entity = projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        model.addAttribute("project", convertToDto(entity));
//        return "project";
//    }
//    
//    @PostMapping
//    public String addProject(@Valid @ModelAttribute("project") ProjectDto project, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "new-project";
//        }
//        projectService.save(convertToEntity(project));
//        
//        return "redirect:/projects";
//    }
//    
//    @GetMapping("/{id}/add-tasks")
//    public String getProjectEditPage(@PathVariable Long id, Model model) {
//        Project project = projectService.findById(id).orElse(new Project());
//        model.addAttribute("project", project);
//        TaskListDto tasksForm = new TaskListDto();
//        
//        for(int i = 1; i <= 3; i++) {
//            tasksForm.addTask(new TaskDto());
//        }
//        
//        model.addAttribute("tasksForm", tasksForm);
//        return "add-tasks";
//    }
//    
//    @PostMapping("/{id}/save-tasks")
//    public String saveTasks(@ModelAttribute TaskListDto tasksForm, @PathVariable Long id, Model model) {
//        Project project = projectService.findById(id).orElse(new Project());
//        projectService.addTasks(project, tasksForm.getTasks().stream().map(t -> convertTaskToEntity(t)).collect(Collectors.toList()));
//        
//        model.addAttribute("project", project);
//        return "redirect:/projects/" + project.getId();
//    }
    
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
