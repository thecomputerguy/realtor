package com.realtor.io.exceptions;

public class LeadNotFoundException extends RuntimeException{

    public LeadNotFoundException(String message){
        super(message);
    }
}
