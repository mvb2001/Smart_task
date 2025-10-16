package org.real.smart_task.Services;

import lombok.RequiredArgsConstructor;
import org.real.smart_task.model.Task;
import org.real.smart_task.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

        private final TaskRepo taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByPriority() {
        List<Task> tasks = taskRepository.findAll();
        tasks.sort((t1, t2) -> Integer.compare(t2.getPriorityScore(), t1.getPriorityScore()));
        return tasks;
    }
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {

        Task existingTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + task.getId()));


        // Update the fields
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDeadline(task.getDeadline());
        existingTask.setImportance(task.getImportance());
        existingTask.setCategory(task.getCategory());
        existingTask.setFilePath(task.getFilePath());

        // priorityScore will be recalculated automatically on save
        return taskRepository.save(existingTask);
    }

}




