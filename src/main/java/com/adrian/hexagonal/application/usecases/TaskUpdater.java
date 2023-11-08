package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.UpdateTask;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TaskUpdater implements UpdateTask {

    ///* DI
    private final TaskRepository taskRepository;


    @Override
    public Task updateTask(Long id, Task updatedTask) {
        taskRepository.findOne(id).orElseThrow(
                () -> new RuntimeException("Tas does not exist with ID ".concat(id.toString()))
        );

        return taskRepository.save(updatedTask);
    }

}
