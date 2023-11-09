package com.adrian.hexagonal.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;


    // // Mapping
    /*public static TaskEntity mapModelToEntity(Task task) {
        return TaskEntity.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .creationDate(task.getCreationDate())
                .completed(task.isCompleted())
                .build();
    }

    public Task toDomainModel() {
        return Task.builder()
                .id(id)
                .title(title)
                .description(description)
                .creationDate(creationDate)
                .completed(completed)
                .build();
    }*/

}
