package com.castmovie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmNotFoundException extends Exception{

    public FilmNotFoundException(String filmName){
        super(String.format("Film with name %s not found in the system,", filmName));
    }

    public FilmNotFoundException(Long id){
        super(String.format("Film with id %s not sound in the system.", id));
    }

}
