package com.bookloverbackend.bookloverbackend.exceptions;

public class WrongCredentials extends Exception{
    public WrongCredentials(String message){
        super(message);
    }
}
