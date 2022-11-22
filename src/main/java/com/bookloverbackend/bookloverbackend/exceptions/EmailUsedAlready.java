package com.bookloverbackend.bookloverbackend.exceptions;

public class EmailUsedAlready extends Exception{
    public EmailUsedAlready(String message){
        super(message);
    }
}
