package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DisponibilidadeNotFoundException extends Exception{
    public DisponibilidadeNotFoundException(Long id) {
        super("Disponibilidade not found with ID "+ id);
    }
}
