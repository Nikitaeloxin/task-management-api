package com.univrs.testtask.dto;

import com.univrs.testtask.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private TaskStatus status;
    private String text;
}
