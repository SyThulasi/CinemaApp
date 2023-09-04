package com.example.cinemaApp.Controller;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
import com.example.cinemaApp.DTO.SeatCategoryDTO;
import com.example.cinemaApp.DTO.ShowDTO;
import com.example.cinemaApp.Entity.*;
import com.example.cinemaApp.Repository.*;
import com.example.cinemaApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/cinemaUser/Movies")
@CrossOrigin( allowedHeaders = {})
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private SeatCategoryRepository seatCategoryRepository;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/save")
    public MoviePublishDTO saveMovie(@RequestBody MovieDTO movieDTO){
        return movieService.saveMovie(movieDTO);
    }

    @GetMapping("/save/cinema/{cinemaId}")
    public List<Movie> getMovieFromCinema(@PathVariable("cinemaId") int cinemaId){
        Optional<CinemaUser> cinemaUser = cinemaUserRepository.findById(cinemaId);
        return movieService.getMovieFromCinema(cinemaUser.get());
    }

    @GetMapping("/save/show/{movieID}")
    public List<ShowDTO> getShowsFromMovie(@PathVariable("movieID") int movieID){
        Movie movie = movieRepository.findById(movieID);

        List<Show> shows = showRepository.findByMovie(movie);

        List<ShowDTO> showDTOs = new ArrayList<>();

        for (Show originalShow : shows) {
            ShowDTO simplifiedShow = new ShowDTO();

            simplifiedShow.setShowID(originalShow.getShowID());
            simplifiedShow.setShowDate(originalShow.getShowDate());
            simplifiedShow.setShowTime(originalShow.getShowTime());

            List<SeatCategory> seatCategory = seatCategoryRepository.findByShow(originalShow);
            List<SeatCategoryDTO> seatCategoryDTOs = new ArrayList<>();

            for(SeatCategory seats : seatCategory){
                SeatCategoryDTO simpleSeatCatDTO = new SeatCategoryDTO();

                simpleSeatCatDTO.setAvailableSeatCount(seats.getAvailableSeatCount());
                simpleSeatCatDTO.setType(seats.getType());

                seatCategoryDTOs.add(simpleSeatCatDTO);
            }
            simplifiedShow.setSeatCategoryDTO(seatCategoryDTOs);
            showDTOs.add(simplifiedShow);
        }

        //System.out.println(shows);

        return showDTOs;
    }

    @GetMapping("/save/booking/{showID}")
    public List<Booking> getBookingsFromShow(@PathVariable("showID") Long showID){


        List<Booking> bookings = bookingRepository.findByShowID(showID);

        return bookings;
    }


}
