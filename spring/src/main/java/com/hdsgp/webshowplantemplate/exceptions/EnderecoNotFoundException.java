package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnderecoNotFoundException extends Exception {

    public EnderecoNotFoundException(Long id) {
        super("Endereco not found with ID " + id);
    }
}
