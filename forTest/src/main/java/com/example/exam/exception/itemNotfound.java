package com.example.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class itemNotfound extends RuntimeException{
    public itemNotfound(String message){
        super(message);
    }
}
