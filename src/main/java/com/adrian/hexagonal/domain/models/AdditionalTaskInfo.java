package com.adrian.hexagonal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;


// // to fetch data
@Getter
@AllArgsConstructor
public class AdditionalTaskInfo {

    // immutable: just read
    private final Long userId;
    private final String userName;
    private final String userEmail;

}
