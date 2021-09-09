package com.castmovie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CastType {

    ACTOR("Actor"),
    ACTRESS("Actress"),
    DIRECTOR("Director"),
    SCREENWRITER("Screenwriter"),
    PRODUCER("Producer");

    private final String description;

}
