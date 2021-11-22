package com.hdsgp.webshowplantemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CidadeAtuacaoNotFoundException extends  Exception{
    public CidadeAtuacaoNotFoundException(Long id){
        super("CidadeAtuacao not found with ID " + id);
    }
}
