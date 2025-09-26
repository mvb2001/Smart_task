package org.real.smart_task.Services;

import lombok.RequiredArgsConstructor;
import org.real.smart_task.model.Task;
import org.real.smart_task.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepository;

    // Business logic for creating a task
    public Task createTask(Task task) {
        // 1. Validate input (optional)
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }

        if (task.getDeadline() == null) {
            throw new IllegalArgumentException("Deadline must be set");
        }

        // 2. You can add default values if needed
        if (task.getImportance() == 0) {
            task.setImportance(1); // default importance
        }

        // 3. Save task to database
        Task savedTask = taskRepository.save(task);

        // 4. Return the saved task
        return savedTask;
    }

    // 👉 New method to fetch all tasks
        public List<Task> getAllTask() {
            return taskRepository.findAll();
        }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }
}
