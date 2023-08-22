package com.example.cinemaApp.Service;

import com.example.cinemaApp.DTO.MovieDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public interface MovieService {

    String saveMovie(MovieDTO movieDTO);

}
