package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.*;
import com.example.cinemaApp.Repository.*;
import com.example.cinemaApp.Service.ShowServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Component
@Scope
@Service
public class ShowServicesIMPL implements ShowServices {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private SeatCategoryRepository seatCategoryRepository;

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    public void createShowsForMovie(MovieDTO movie,int id) {
        Movie tempMovie = movieRepository.findById(id);
        System.out.println("-----------------------------------------------------------------");
        System.out.println(movie.getMovieID());

        System.out.println(tempMovie);
        Optional<CinemaUser> cinemaUser = cinemaUserRepository.findById(movie.getCinemaId());

        List<Seats> seatCategories = seatsRepository.findByCinemaUser(cinemaUser.get());


        for (String date : movie.getShowDates()) {
            for (String time : movie.getShowTimes()) {

                    Show show = new Show();

                    show.setMovie(tempMovie);
                    show.setShowDate(date);
                    show.setShowTime(time);
                    Show temp = showRepository.save(show);

                for (Seats seatCategory : seatCategories) {
                    SeatCategory seatCategory1 = new SeatCategory();
                    seatCategory1.setType(seatCategory.getType());
                    seatCategory1.setAvailableSeatCount(seatCategory.getCount());
                    seatCategory1.setShow(temp);

                    seatCategoryRepository.save(seatCategory1);
                }
            }
        }
    }

}
