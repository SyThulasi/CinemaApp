package com.example.cinemaApp.Controller;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public String saveMovie(@RequestBody MovieDTO movieDTO){

            Movie temp = new Movie();

        try{
            return movieService.saveMovie(movieDTO);
        } catch (Exception e){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(e);
        }
        return String.valueOf(temp);
    }
}
