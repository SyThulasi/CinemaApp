package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Mapper.MovieMapper;
import com.example.cinemaApp.Repository.MovieRepository;
import com.example.cinemaApp.Service.MovieService;
import com.example.cinemaApp.Service.ShowServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope
@Service
public class MovieServiceIMPL implements MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private ShowServices showServices;

    public MovieServiceIMPL(MovieRepository movieRepository, MovieMapper movieMapper, ShowServices showServices) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.showServices = showServices;
    }

    @Override
    public Movie saveMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();

        movie = movieMapper.mapIn(movieDTO);
        Movie temp = movieRepository.save(movie);
        showServices.createShowsForMovie(movieDTO, temp.getMovieID());

        return movie;
    }
}

