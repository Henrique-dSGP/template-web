package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DadosPessoaNotFoundException extends Exception {

    public DadosPessoaNotFoundException(Long id) {
        super("Dados Pessoa not found with ID "+ id);
    }
}
