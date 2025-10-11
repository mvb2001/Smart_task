package org.real.smart_task.Services;

import lombok.RequiredArgsConstructor;
import org.real.smart_task.model.DailyTask;
import org.real.smart_task.repository.DtaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyTaskService {

    private final DtaskRepository dtaskRepository;

    // Get all tasks in FIFO order
    public List<DailyTask> getAllTasks() {
        return dtaskRepository.findAllByOrderByIdAsc();
    }

    // Add a new task
    public DailyTask addTask(DailyTask task) {
        return dtaskRepository.save(task);
    }

    // Delete only the first task in the queue
    public void deleteTask(Long taskId) throws Exception {
        Optional<DailyTask> firstTaskOpt = dtaskRepository.findFirstByOrderByIdAsc();
        if (firstTaskOpt.isEmpty()) {
            throw new Exception("No tasks in the queue!");
        }

        DailyTask firstTask = firstTaskOpt.get();
        if (!firstTask.getId().equals(taskId)) {
            throw new Exception("You can only delete the first task in the queue!");
        }

        dtaskRepository.deleteById(taskId);
    }
}
