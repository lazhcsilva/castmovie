package com.castmovie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FilmAlreadyRegisteredException extends Exception{

    public FilmAlreadyRegisteredException(String filmName){
        super(String.format("Film with name %s already registered in the system.", filmName));
    }

}
