package com.realtor.io.exceptions;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message){
        super(message);
    }
}
