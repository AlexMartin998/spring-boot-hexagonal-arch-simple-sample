package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.RetrieveTask;
import com.adrian.hexagonal.infrastructure.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class TaskRetriever implements RetrieveTask {

    ///* DI
    private final TaskRepository taskRepository;


    @Override
    public Task findOne(Long id) {
        return taskRepository.findOne(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "ID", id)
        );
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

}
