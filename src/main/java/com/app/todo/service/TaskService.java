package com.app.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todo.model.Task;
import com.app.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public void createTask(String title){
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public void toggleTask(Long id){
        Task task =taskRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Invalid task ID: " + id));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);

    }
}
