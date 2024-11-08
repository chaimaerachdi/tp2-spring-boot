package com.jenkins.tp2springboot.service.implementations;

import com.jenkins.tp2springboot.DTO.TaskRepository;
import com.jenkins.tp2springboot.Task;
import com.jenkins.tp2springboot.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> optionalTask=taskRepository.findById(id);
        if (!optionalTask.isPresent()){
            throw new RuntimeException("aucune tache trouvee !");
        }
        else {
            return optionalTask.get();
        }
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> optionalTask=taskRepository.findById(id);
        if (!optionalTask.isPresent()){
            throw new RuntimeException("la tache que vous tentez de modifier n'existe pas !");
        }
        else {
            Task taskToUpdate= optionalTask.get();
            taskRepository.save(updatedTask);
        }
        return updatedTask;
    }
//Méthode qui supprime une tâche par ID.
    @Override
    public void deleteTask(Long id) {
//        verifier  que la tache avec cet id existe
        Optional<Task> optionalTask=taskRepository.findById(id);
        if (!optionalTask.isPresent()){
            throw new RuntimeException("la tache que vous tentez de supprimer n'existe pas !");
        }
        else {
            Task taskToDelete= optionalTask.get();
            taskRepository.delete(taskToDelete);
        }
    }
}
