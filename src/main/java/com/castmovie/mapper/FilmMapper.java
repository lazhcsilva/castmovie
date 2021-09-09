package com.castmovie.mapper;

import com.castmovie.dto.FilmDTO;
import com.castmovie.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    Film toModel(FilmDTO filmDTO);

    FilmDTO toDTO(Film film);

}
