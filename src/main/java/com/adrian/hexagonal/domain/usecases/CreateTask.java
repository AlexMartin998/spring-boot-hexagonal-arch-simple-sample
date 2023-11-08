package com.adrian.hexagonal.domain.usecases;

import com.adrian.hexagonal.domain.models.Task;


// to abstract impls on Services & promote Composition instead of Inheritance
public interface CreateTask {

    // NOOO puede ser  run/execute   xq lo usamos en conjunto a otros UseCases en el Service
    Task createTask(Task task);
}
