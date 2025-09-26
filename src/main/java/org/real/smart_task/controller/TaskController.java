package org.real.smart_task.controller;

import lombok.RequiredArgsConstructor;
import org.real.smart_task.Services.AuthService;
import org.real.smart_task.Services.TaskService;
import org.springframework.web.bind.annotation.*;
import org.real.smart_task.model.Task;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    @GetMapping("/getTasks")
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }
    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task with ID " + id + " deleted successfully!";
    }


}
