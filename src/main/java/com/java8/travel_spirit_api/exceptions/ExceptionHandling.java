package com.java8.travel_spirit_api.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(NullPointerException.class)
    public CustomException handleNullPointer(NullPointerException e) {
        return new CustomException("An error happened!", "501", LocalDate.now());
    }
}
