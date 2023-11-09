package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.DeleteTask;
import com.adrian.hexagonal.infrastructure.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TaskDeleter implements DeleteTask {

    ///* DI
    private final TaskRepository taskRepository;


    @Override
    public boolean deleteTask(Long id) {
        taskRepository.findOne(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "ID", id)
        );

        return taskRepository.delete(id);
    }

}
