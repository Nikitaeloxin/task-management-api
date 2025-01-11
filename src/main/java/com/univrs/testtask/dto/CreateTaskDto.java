package com.univrs.testtask.dto;

import com.univrs.testtask.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDto {
    private TaskStatus status;
    private String text;
}
