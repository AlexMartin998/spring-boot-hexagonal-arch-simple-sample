package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.CreateTask;
import lombok.AllArgsConstructor;


// TaskCreator to avoid using Impl suffix and set more semantic name
@AllArgsConstructor
public class TaskCreator implements CreateTask {

    ///* DI
    private final TaskRepository taskRepository;


    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

}
