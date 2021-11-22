package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanoNotFoundException extends  Exception{

    public PlanoNotFoundException(Long id) {
        super("Plano not found with ID " + id);
    }
}
