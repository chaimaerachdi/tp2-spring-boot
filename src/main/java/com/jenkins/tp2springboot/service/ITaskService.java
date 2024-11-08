package com.jenkins.tp2springboot.service;

import com.jenkins.tp2springboot.Task;

import java.util.List;

public interface ITaskService {
    Task createTask (Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTask(Long id,Task updatedTask);
    void deleteTask(Long id);
}
