package com.example.cinemaApp.Mapper;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
import com.example.cinemaApp.DTO.SeatCategoryDTO;
import com.example.cinemaApp.DTO.ShowDTO;
import com.example.cinemaApp.Entity.*;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import com.example.cinemaApp.Repository.SeatCategoryRepository;
import com.example.cinemaApp.Repository.SeatsRepository;
import com.example.cinemaApp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MoviePublishMapper {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatCategoryRepository seatCategoryRepository;

    @Autowired
    private SeatsRepository seatsRepository;

    public MoviePublishDTO mapIn(Movie movie, int id){
        MoviePublishDTO temp = new MoviePublishDTO();

        temp.setMovieID(movie.getMovieID());
        temp.setMovieName(movie.getMovieName());
        temp.setDescription(movie.getDescription());
        temp.setDurationMinutes(movie.getDurationMinutes());
        temp.setImgURL(movie.getImgURL());
        temp.setLanguage(movie.getLanguage());
        temp.setReleaseDate(movie.getReleaseDate());

        System.out.println(id);
        System.out.println(".................................................................");
        Optional<CinemaUser> cinemaUsers = cinemaUserRepository.findById(id);
        System.out.println("###################################################################");
        if (cinemaUsers.isPresent()) {

            CinemaUser cinemaUser = (CinemaUser) cinemaUsers.get();

            List<Seats> seatsMap = seatsRepository.findByCinemaUser(cinemaUser);
            Map<String, Double> tempSeats = new HashMap<>();
            for(Seats seats1 : seatsMap){
                tempSeats.put(seats1.getType(),seats1.getPrice());
            }
            temp.setSeats(tempSeats);

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
            temp.setCinemaUser(cinemaUser);
            temp.setShows(showDTOs);

            return temp;
        } else {
            System.out.println("Cinema User Cannot be found!");
            return null;
        }

    }

}
