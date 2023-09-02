package com.example.cinemaApp.Controller;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import com.example.cinemaApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/cinemaUser/Movies")
@CrossOrigin( allowedHeaders = {})
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/save")
    public MoviePublishDTO saveMovie(@RequestBody MovieDTO movieDTO){
//            System.out.println(movieDTO);

        return movieService.saveMovie(movieDTO);
    }

    @GetMapping("/save/cinema/{cinemaId}")
    public List<Movie> getMovieFromCinema(@PathVariable("cinemaId") int cinemaId){
        Optional<CinemaUser> cinemaUser = cinemaUserRepository.findById(cinemaId);
        return movieService.getMovieFromCinema(cinemaUser.get());
    }

}
