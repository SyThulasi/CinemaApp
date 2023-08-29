package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Kafka.JsonKafkaProducer;
import com.example.cinemaApp.Mapper.MovieMapper;
import com.example.cinemaApp.Mapper.MoviePublishMapper;
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
    private MoviePublishMapper moviePublishMapper;

    @Autowired
    private ShowServices showServices;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    public MovieServiceIMPL(MovieRepository movieRepository, MovieMapper movieMapper, ShowServices showServices) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.showServices = showServices;
    }

    @Override
    public MoviePublishDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();

        movie = movieMapper.mapIn(movieDTO);
        Movie temp = movieRepository.save(movie);
        showServices.createShowsForMovie(movieDTO, temp.getMovieID());

        // Create DTO for publish  movie

        MoviePublishDTO moviePublishDTO = new MoviePublishDTO();

        moviePublishDTO = moviePublishMapper.mapIn(temp,temp.getMovieID());
        jsonKafkaProducer.sendMessage(moviePublishDTO);

        return moviePublishDTO;
    }
}

