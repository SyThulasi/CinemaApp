package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Repository.MovieRepository;
import com.example.cinemaApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Component
@Scope
@Service
public class MovieServiceIMPL implements MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public String saveMovie(MovieDTO movieDTO) {
        Movie movie = new Movie(
                movieDTO.getMovieID(),
                movieDTO.getMovieName(),
                movieDTO.getDescription(),
                movieDTO.getLanguage(),
                movieDTO.getDurationMinutes(),
                movieDTO.getReleaseDate(),
                movieDTO.getImgURL(),
                movieDTO.getShowDates(),
                movieDTO.getShowTimes(),
                movieDTO.getCinemaUser()
        );
        movieRepository.save(movie);
        return movie.getMovieName();
    }
}
