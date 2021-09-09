package com.castmovie.service;

import com.castmovie.exception.FilmAlreadyRegisteredException;
import com.castmovie.dto.FilmDTO;
import com.castmovie.entity.Film;
import com.castmovie.exception.FilmNotFoundException;
import com.castmovie.mapper.FilmMapper;
import com.castmovie.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper = FilmMapper.INSTANCE;


    public FilmDTO createFilm(FilmDTO filmDTO) throws FilmAlreadyRegisteredException{
        verifyIfIsAlreadyRegistered(filmDTO.getName());
        Film film = filmMapper.toModel(filmDTO);
        Film savedFilm = filmRepository.save(film);
        return filmMapper.toDTO(savedFilm);
    }

    public FilmDTO findByName(String name) throws FilmNotFoundException{
        Film foundFilm = filmRepository.findByName(name).orElseThrow(() -> new FilmNotFoundException(name));
        return filmMapper.toDTO(foundFilm);
    }

    public List<FilmDTO> listAll(){
        return filmRepository.findAll()
                .stream()
                .map(filmMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws FilmNotFoundException{
        verifyIfExists(id);
        filmRepository.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws FilmAlreadyRegisteredException{
        Optional<Film> optSavedFilm = filmRepository.findByName(name);
        if(optSavedFilm.isPresent()){
            throw new FilmAlreadyRegisteredException(name);
        }
    }

    private Film verifyIfExists(Long id) throws FilmNotFoundException {
        return filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }

}
