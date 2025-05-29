package com.java.sk.phonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PhonebookNotFoundException extends RuntimeException {
    public PhonebookNotFoundException(String message){
        super(message);
    }
}
