package com.univrs.testtask.service.impl;

import com.univrs.testtask.dto.CreateTaskDto;
import com.univrs.testtask.dto.TaskDto;
import com.univrs.testtask.exceptions.TaskAlreadyExistsException;
import com.univrs.testtask.exceptions.TaskNotFoundException;
import com.univrs.testtask.model.Task;
import com.univrs.testtask.model.TaskStatus;
import com.univrs.testtask.repository.TaskRepository;
import com.univrs.testtask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceV1 implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Override
    public TaskDto addTask(CreateTaskDto newTask) {
        if (taskRepository.existsByText(newTask.getText())) {
            throw new TaskAlreadyExistsException("Task with text '" + newTask.getText() + "' already exists");
        }
        Task savedTask = taskRepository.save(modelMapper.map(newTask, Task.class));
        return modelMapper.map(savedTask, TaskDto.class);
    }

    @Override
    @Transactional
    public TaskDto updateStatus(Long id, TaskStatus status) {
        Task retrivedTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " is not found"));
        retrivedTask.setStatus(status);
        return modelMapper.map(taskRepository.save(retrivedTask), TaskDto.class);
    }

    @Override
    public void deleteTask(Long id) {
        Task retrivedTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " is not found"));
        taskRepository.deleteById(id);
        modelMapper.map(retrivedTask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class)).toList();
    }

    @Override
    public List<TaskDto> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class)).toList();
    }
}
