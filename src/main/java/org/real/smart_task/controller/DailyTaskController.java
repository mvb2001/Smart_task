package org.real.smart_task.controller;

import lombok.RequiredArgsConstructor;
import org.real.smart_task.Services.DailyTaskService;
import org.real.smart_task.model.DailyTask;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-tasks")
@RequiredArgsConstructor
public class DailyTaskController {

    private final DailyTaskService dailyTaskService;

    // Get all tasks in FIFO order
    @GetMapping
    public ResponseEntity<List<DailyTask>> getAllTasks() {
        List<DailyTask> tasks = dailyTaskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // Add a new task
    @PostMapping
    public ResponseEntity<DailyTask> addTask(@RequestBody DailyTask task) {
        DailyTask createdTask = dailyTaskService.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    // Delete only the first task in the queue
    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        try {
            dailyTaskService.deleteTask(taskId);
            return ResponseEntity.ok("Task deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
