package com.piyushpatel2005.ls.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.piyushpatel2005.ls.persistence.model.Task;

@SpringBootTest
public class TaskRepositoryIntegrationTest {

    @Autowired
    ITaskRepository taskRepository;
    
    @Test
    public void whenSavingNewTask_thenSuccess() {
        Task newTask = new Task("First Task", "First Task", LocalDate.now(), LocalDate.now());
        assertThat(taskRepository.save(newTask)).isNotNull();
    }
    
    @Test
    public void givenTask_whenFindById_thenSuccess() {
        Task newTask = new Task("First Task", "First Task", LocalDate.now(), LocalDate.now());
        taskRepository.save(newTask);
        
        Optional<Task> retrievedTask = taskRepository.findById(newTask.getId());
        assertThat(retrievedTask.get()).isEqualTo(newTask);
    }
    
    @Test
    public void givenProjectCreated_whenFindByTaskNameMatches_thenSuccess() {
        Task task1 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        Task task2 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        Task task3 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());
        Task task4 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());
        
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
        
        List<Task> retrievedTasks = taskRepository.findByNameMatches("High");
        assertThat(retrievedTasks, contains(task3, task4));
    }
}
