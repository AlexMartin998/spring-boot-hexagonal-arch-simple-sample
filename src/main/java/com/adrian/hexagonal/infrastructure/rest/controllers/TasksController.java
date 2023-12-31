package com.adrian.hexagonal.infrastructure.rest.controllers;

import com.adrian.hexagonal.application.services.TaskService;
import com.adrian.hexagonal.domain.models.Task;
import com.adrian.hexagonal.infrastructure.rest.dtos.CreateTaskDto;
import com.adrian.hexagonal.infrastructure.rest.dtos.TaskResponseDto;
import com.adrian.hexagonal.infrastructure.rest.dtos.UpdateTaskDto;
import com.adrian.hexagonal.infrastructure.shared.mappers.TaskMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TasksController {

    ///* DI
    private final TaskService tasksService;
    private final TaskMapper taskMapper;


    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody CreateTaskDto task) {
        Task createdTask = tasksService.createTask(taskMapper.createDtoToEntity(task));
        return new ResponseEntity<>(taskMapper.entityToTaskResponseDto(createdTask), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(taskMapper.entityToTaskResponseDto(tasksService.findOne(id)));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> findAll() {
        return ResponseEntity.ok(tasksService.findAll().stream()
                .map(taskMapper::entityToTaskResponseDto)
                .toList()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDto> update(@PathVariable Long id, @Valid @RequestBody UpdateTaskDto updateTaskDto) {
        Task updatedTask = tasksService.updateTask(id, taskMapper.updateDtoToEntity(updateTaskDto));

        return ResponseEntity.ok(taskMapper.entityToTaskResponseDto(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        tasksService.deleteTask(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
