package com.castmovie.controller;

import com.castmovie.exception.FilmAlreadyRegisteredException;
import com.castmovie.dto.FilmDTO;
import com.castmovie.exception.FilmNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages film")
public interface FilmControllerDocs {

    @ApiOperation(value = "Film creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucess film creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    FilmDTO createFilm(FilmDTO filmDTO) throws FilmAlreadyRegisteredException;

    @ApiOperation(value = "Returns film found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucess beer found in the system"),
            @ApiResponse(code = 404, message = "Film with given name not found")
    })
    FilmDTO findByName(@PathVariable String name) throws FilmNotFoundException;

    @ApiOperation(value = "Returns a list of all films registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all films registered in the system")
    })
    List<FilmDTO> listFilms();

}
