package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TipoPessoaNotFoundException extends Exception {

    public TipoPessoaNotFoundException(Long id) {
        super("Tipo Pessoa not found with ID " + id);
    }
}
