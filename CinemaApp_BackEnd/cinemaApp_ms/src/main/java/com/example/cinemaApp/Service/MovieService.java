package com.example.cinemaApp.Service;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.Movie;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope
public interface MovieService {

    Movie saveMovie(MovieDTO movieDTO);

}
