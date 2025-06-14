package com.app.todo.service;

import com.app.todo.model.Task;
import com.app.todo.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskSevice(TaskRepository taskrepository ){
        this.taskRepository =taskRepository;
    }
    public List<Task> getAllTasks(){
        return taskReposiotry.findAll();
    }
}
