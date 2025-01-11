package com.univrs.testtask.controller;

import com.univrs.testtask.dto.CreateTaskDto;
import com.univrs.testtask.dto.TaskDto;
import com.univrs.testtask.model.TaskStatus;
import com.univrs.testtask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public TaskDto addTask(@RequestBody CreateTaskDto newTask) {

        return taskService.addTask(newTask);
    }

    @PutMapping("/{id}")
    public TaskDto updateStatus(@PathVariable("id") Long id, @RequestParam("status") TaskStatus status) {
        return taskService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping()
    public List<TaskDto> getTasksByStatus(@RequestParam(value = "status", required = false) TaskStatus status) {
        return status==null? taskService.getAllTasks():taskService.getTasksByStatus(status);
    }
}
