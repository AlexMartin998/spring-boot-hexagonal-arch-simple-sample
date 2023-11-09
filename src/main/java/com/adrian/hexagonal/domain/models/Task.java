package com.adrian.hexagonal.domain.models;

import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

}
