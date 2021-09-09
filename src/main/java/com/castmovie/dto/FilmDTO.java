package com.castmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 150)
    private String name;

    @NotNull
    @Max(150)
    private Integer age;

}
