package com.example.pink_project.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends Exception {
    private String message;
    private HttpStatus status;

    public AppException(String message, HttpStatus status ) {
        this.message = message;
        this.status = status;
    }

}
