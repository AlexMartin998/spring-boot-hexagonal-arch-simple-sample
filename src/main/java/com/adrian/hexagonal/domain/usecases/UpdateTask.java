package com.adrian.hexagonal.domain.usecases;

import com.adrian.hexagonal.domain.models.Task;

import java.util.Optional;


public interface UpdateTask {
    Optional<Task> updateTask(Long id, Task updatedTask);
}
