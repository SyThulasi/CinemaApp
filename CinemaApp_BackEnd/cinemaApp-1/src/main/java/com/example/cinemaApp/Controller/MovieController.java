package com.example.cinemaApp.Controller;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/cinemaUser")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/Movies/save")
    public String saveMovie(@RequestBody MovieDTO movieDTO){


        return movieService.saveMovie(movieDTO);
    }
}
