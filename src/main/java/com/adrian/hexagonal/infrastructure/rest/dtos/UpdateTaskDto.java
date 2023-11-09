package com.adrian.hexagonal.infrastructure.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;

    private LocalDateTime creationDate;

    @NotNull
    private boolean completed;

}
