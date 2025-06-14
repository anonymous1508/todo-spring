package com.app.todo.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import com.app.todo.model.Task;
import com.app.todo.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
@GetMapping
public String getTasks(Model model){
    List<Task> tasks = taskService.getAllTasks();
    model.addAttribute("tasks", tasks);
    return "tasks"; // Ensure you have src/main/resources/templates/tasks.html
}
@PostMapping
public String postMethodName(@RequestParam String title) {
    taskService.createTask(title);
    return "redirect:/tasks";
}
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks";

    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/tasks";
    }
    

}
