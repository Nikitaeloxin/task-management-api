package com.univrs.testtask.repository;

import com.univrs.testtask.model.Task;
import com.univrs.testtask.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    boolean existsByText(String text);

    List<Task> findByStatus(TaskStatus status);
}
