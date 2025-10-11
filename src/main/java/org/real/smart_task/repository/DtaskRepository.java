package org.real.smart_task.repository;

import org.real.smart_task.model.DailyTask;
import org.real.smart_task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DtaskRepository extends JpaRepository<DailyTask, Long> {

    Optional<DailyTask> findFirstByOrderByIdAsc(); // get the first task in the queue
    List<DailyTask> findAllByOrderByIdAsc();
}
