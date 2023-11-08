package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.DeleteTask;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TaskDeleter implements DeleteTask {

    ///* DI
    private final TaskRepository taskRepository;


    @Override
    public boolean deleteTask(Long id) {
        taskRepository.findOne(id).orElseThrow(
                () -> new RuntimeException("Tas does not exist with ID ".concat(id.toString()))
        );

        return taskRepository.delete(id);
    }

}
