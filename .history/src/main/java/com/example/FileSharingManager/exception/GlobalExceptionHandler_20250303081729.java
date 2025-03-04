package com.example.FileSharingManager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    
    public ResponseEntity<?> handleFileNotFoundException(FileNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
