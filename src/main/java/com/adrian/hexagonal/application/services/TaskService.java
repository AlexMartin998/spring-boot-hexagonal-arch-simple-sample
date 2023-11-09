package com.adrian.hexagonal.application.services;

import com.adrian.hexagonal.domain.models.AdditionalTaskInfo;
import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.domain.usecases.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class TaskService implements CreateTask, UpdateTask, DeleteTask, RetrieveTask, GetAdditionalTaskInfo {

    ///* DI: UseCases
    private final CreateTask taskCreator;
    private final UpdateTask taskUpdater;
    private final DeleteTask taskDeleter;
    private final RetrieveTask taskRetriever;
    private final GetAdditionalTaskInfo additionalTaskInfoRetriever;


    // // UseCases (Composition over the Inheritance)
    @Override
    @Transactional
    public Task createTask(Task task) {
        return taskCreator.createTask(task);
    }

    @Override
    @Transactional
    public boolean deleteTask(Long id) {
        return taskDeleter.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return additionalTaskInfoRetriever.getAdditionalTaskInfo(id);
    }

    @Override
    public Task findOne(Long id) {
        return taskRetriever.findOne(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRetriever.findAll();
    }

    @Override
    @Transactional
    public Task updateTask(Long id, Task updatedTask) {
        return taskUpdater.updateTask(id, updatedTask);
    }

}
