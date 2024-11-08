package com.jenkins.tp2springboot.controller;

import com.jenkins.tp2springboot.Task;
import com.jenkins.tp2springboot.service.implementations.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/create")
    public ResponseEntity<String> createNewTask(@RequestBody Task task){
       taskService.createTask(task);
       return new ResponseEntity<>("task creeated successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks=taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.CREATED);
    }
    @GetMapping("/get/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId){
        Task task=taskService.getTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
    @PutMapping("update/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId
                                           ,@RequestBody Task NewTask){
        Task task=taskService.updateTask(taskId, NewTask);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{taskId}")
    public void getAllTasks(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

}
