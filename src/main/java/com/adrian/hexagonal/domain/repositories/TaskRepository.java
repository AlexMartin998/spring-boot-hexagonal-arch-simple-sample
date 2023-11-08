package com.adrian.hexagonal.domain.repositories;


import com.adrian.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;


public interface TaskRepository {

    Task create(Task task);
    Optional<Task> findOne(Long id);
    List<Task> findAll();
    Optional<Task> update(Task task);
    boolean delete(Long id);

}
