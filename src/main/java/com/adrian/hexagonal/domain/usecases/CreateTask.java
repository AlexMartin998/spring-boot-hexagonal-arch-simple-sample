package com.adrian.hexagonal.domain.usecases;

import com.adrian.hexagonal.domain.models.Task;


// to abstract impls on Services & promote Composition instead of Inheritance
public interface CreateTask {
    Task createTask(Task task);
}
