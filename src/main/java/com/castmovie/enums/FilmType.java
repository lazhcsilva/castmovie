package com.castmovie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FilmType {

    ACTION("Action"),
    COMEDY("Comedy"),
    HORROR("Horror"),
    ADVENTURE("Adventure");

    private final String description;

}
