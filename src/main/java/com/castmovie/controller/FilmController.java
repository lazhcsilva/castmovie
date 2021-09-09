package com.castmovie.controller;

import com.castmovie.exception.FilmAlreadyRegisteredException;
import com.castmovie.dto.FilmDTO;
import com.castmovie.exception.FilmNotFoundException;
import com.castmovie.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/films")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FilmDTO createFilm(@RequestBody @Valid FilmDTO filmDTO) throws FilmAlreadyRegisteredException {
        return filmService.createFilm(filmDTO);
    }

    @GetMapping("/{name}")
    public FilmDTO findByName(@PathVariable String name) throws FilmNotFoundException{
        return filmService.findByName(name);
    }

    @GetMapping
    public List<FilmDTO> listFilms(){
        return filmService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws FilmNotFoundException{
        filmService.deleteById(id);
    }

}
