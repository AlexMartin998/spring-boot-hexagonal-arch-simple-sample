package com.adrian.hexagonal.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends RuntimeException {

    private String message;

}
