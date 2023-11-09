package com.adrian.hexagonal.infrastructure.persistence.repositories;

import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.infrastructure.persistence.entities.TaskEntity;
import com.adrian.hexagonal.infrastructure.shared.mappers.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository  // DI
@AllArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepository {

    ///* DI: Inject JPA Implementation
    private final JpaTaskRepository jpaTaskRepository;
    private final TaskMapper taskMapper;


    @Override
    public Task save(Task task) {
        /*// UPD
        if (task.getId() != null) {
            TaskEntity taskEntity = findOneById(task.getId());
            if (taskEntity == null) return null;

            return taskMapper.entityToDomainModel(
                    jpaTaskRepository.save(taskMapper.domainModelToEntity(task))
            );
        }*/

        // Create
        TaskEntity taskEntity = taskMapper.domainModelToEntity(task);

        return taskMapper.entityToDomainModel(jpaTaskRepository.save(taskEntity));
    }

    @Override
    public Optional<Task> findOne(Long id) {
        TaskEntity taskEntity = findOneById(id);
        if (taskEntity == null) return Optional.empty();

        return Optional.ofNullable(taskMapper.entityToDomainModel(taskEntity));
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(taskMapper::entityToDomainModel)
                .toList();
    }

    @Override
    public boolean delete(Long id) {
        TaskEntity taskEntity = findOneById(id);
        if (taskEntity == null) return false;

        jpaTaskRepository.delete(taskEntity);
        return true;
    }


    private TaskEntity findOneById(Long id) {
        return jpaTaskRepository.findById(id).orElse(null);
    }

}
