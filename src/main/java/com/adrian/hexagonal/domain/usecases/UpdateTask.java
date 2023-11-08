package com.adrian.hexagonal.domain.usecases;

import com.adrian.hexagonal.domain.models.Task;

import java.util.Optional;


public interface UpdateTask {
    Task updateTask(Long id, Task updatedTask);
}
