
package com.taskflow.repository;

import com.taskflow.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByPriority(Task.Priority priority);

    List<Task> findByCompleted(boolean completed);
}
