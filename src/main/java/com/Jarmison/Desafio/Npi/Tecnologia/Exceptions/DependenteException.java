package com.Jarmison.Desafio.Npi.Tecnologia.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DependenteException extends RuntimeException{
    private final long serialVersionUID = 1L;
    public DependenteException (String messagem){
        super(messagem);
    }
}
