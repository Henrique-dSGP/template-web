package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocalNotFoundException extends  Exception{

    public LocalNotFoundException(Long id) {
        super("Local not found with ID " + id);
    }
}
