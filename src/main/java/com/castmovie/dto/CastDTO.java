package com.castmovie.dto;

import com.castmovie.enums.CastType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CastDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 150)
    private String name;

    @NotNull
    @Max(120)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CastType castType;

}
