package com.example.SpringTest.exception;

public class PersonAlredyExistException extends Exception{
    public PersonAlredyExistException(String message) {
        super(message);
    }
}
