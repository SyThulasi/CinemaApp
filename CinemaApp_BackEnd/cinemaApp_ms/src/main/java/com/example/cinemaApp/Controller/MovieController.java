package com.example.cinemaApp.Controller;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/cinemaUser/Movies")
@CrossOrigin( allowedHeaders = {})
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/save")
    public Movie saveMovie(@RequestBody MovieDTO movieDTO){
//            System.out.println(movieDTO);
        movieService.saveMovie(movieDTO);
        return null;
    }

    @GetMapping("/save")
    public List<Movie> getMovies(){

        return movieService.getMovies();
    }

}
