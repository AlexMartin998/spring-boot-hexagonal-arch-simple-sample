package com.adrian.hexagonal.domain.usecases;

import com.adrian.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTask {
    Optional<Task> findOne(Long id);
    List<Task> findAll();
}
