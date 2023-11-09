package com.adrian.hexagonal.infrastructure.persistence.repositories;

import com.adrian.hexagonal.infrastructure.persistence.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {

}
