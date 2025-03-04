package com.example.FileSharingManager.exception;

public class FileNotFoundException extends RuntimeException{
    
    public FileNotFoundException(String message){
        super(message);
    }
}
