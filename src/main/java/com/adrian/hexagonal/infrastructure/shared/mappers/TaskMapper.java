package com.adrian.hexagonal.infrastructure.shared.mappers;

import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.infrastructure.persistence.entities.TaskEntity;
import com.adrian.hexagonal.infrastructure.rest.dtos.CreateTaskDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ModelMapper modelMapper;


    public Task createDtoToEntity(CreateTaskDto createTaskDto) {
        return modelMapper.map(createTaskDto, Task.class);
    }

    public Task entityToDomainModel(TaskEntity taskEntity) {
        return modelMapper.map(taskEntity, Task.class);
    }

}
