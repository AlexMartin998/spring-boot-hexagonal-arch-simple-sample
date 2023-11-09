package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.UpdateTask;
import com.adrian.hexagonal.infrastructure.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TaskUpdater implements UpdateTask {

    ///* DI
    private final TaskRepository taskRepository;


    /*@Override
    public Task updateTask(Long id, Task updatedTask) {
        updatedTask.setId(id);
        Task task = taskRepository.save(updatedTask);

        if (task == null) throw new ResourceNotFoundException("Task", "ID", id);

        return task;
    }*/


    @Override
    public Task updateTask(Long id, Task updatedTask) {
        taskRepository.findOne(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "ID", id)
        );

        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

}
