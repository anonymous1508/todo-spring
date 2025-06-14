package com.app.todo.service;


@service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskSevice(TaskRepository taskrepository ){
        this.taskRepository =taskRepository;
    }
    public List<Task> getAllTasks(){
        return taskReposiotry.findAll();
    }
}
