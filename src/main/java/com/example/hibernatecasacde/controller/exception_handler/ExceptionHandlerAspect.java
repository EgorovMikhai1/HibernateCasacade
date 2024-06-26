package com.example.hibernatecasacde.controller.exception_handler;

import com.example.hibernatecasacde.exceptions.AuthorAlreadyExistException;
import com.example.hibernatecasacde.exceptions.AuthorNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAspect {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<String> handleAuthorNotFoundException(AuthorNotFoundException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body("!!!!" + ex.getMessage());
    }

    @ExceptionHandler(AuthorAlreadyExistException.class)
    public ResponseEntity<String> handleAuthorAlreadyExistException(AuthorAlreadyExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .headers(headers)
                .body("!!!!" + ex.getMessage());
    }
}