package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServicoNotFoundException extends Exception {

    public ServicoNotFoundException(Long id) {
        super("Servico not found with ID "+ id);
    }
}
