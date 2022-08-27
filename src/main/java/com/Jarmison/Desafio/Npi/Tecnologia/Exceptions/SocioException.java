package com.Jarmison.Desafio.Npi.Tecnologia.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SocioException  extends RuntimeException{
    private final long serialVersionUID = 1L;
    public SocioException (String messagem){
        super(messagem);
    }
}
