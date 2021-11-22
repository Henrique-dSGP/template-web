package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UFNotFoundException extends Exception{

    public UFNotFoundException(Long id){
        super("UF not found with ID "+ id);
    }
}