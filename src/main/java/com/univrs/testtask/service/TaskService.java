package com.univrs.testtask.service;

import com.univrs.testtask.dto.CreateTaskDto;
import com.univrs.testtask.dto.TaskDto;
import com.univrs.testtask.model.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskDto addTask(CreateTaskDto newTask);

    TaskDto updateStatus(Long id, TaskStatus status);

    void deleteTask(Long id);

    List<TaskDto> getAllTasks();

    List<TaskDto> getTasksByStatus(TaskStatus status);
}
