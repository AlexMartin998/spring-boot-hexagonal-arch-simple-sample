package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.RetrieveTask;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class TaskRetriever implements RetrieveTask {

    ///* DI
    private final TaskRepository taskRepository;


    @Override
    public Task findOne(Long id) {
        return taskRepository.findOne(id).orElseThrow(
                () -> new RuntimeException("Task does not exist with ID ".concat(id.toString()))
        );
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

}
