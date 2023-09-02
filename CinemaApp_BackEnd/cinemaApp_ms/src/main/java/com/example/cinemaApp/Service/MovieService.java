package com.example.cinemaApp.Service;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Movie;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope
public interface MovieService {

    MoviePublishDTO saveMovie(MovieDTO movieDTO);

    List<Movie> getMovieFromCinema(CinemaUser cinemaUser);

    // public Movie createMovieWithShows(Movie movie);

}
