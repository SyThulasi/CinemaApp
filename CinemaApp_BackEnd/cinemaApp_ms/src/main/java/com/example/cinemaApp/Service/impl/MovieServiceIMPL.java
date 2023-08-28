package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Mapper.MovieMapper;
import com.example.cinemaApp.Repository.MovieRepository;
import com.example.cinemaApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Scope
@Service
public class MovieServiceIMPL implements MovieService {
    
    @Autowired
    private MovieRepository movieRepository;


    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Movie saveMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();

        movie = movieMapper.mapIn(movieDTO);
//        System.out.println(movie);
//        System.out.println("============================================================================================================");

        movieRepository.save(movie);
        return movie;
    }

}

