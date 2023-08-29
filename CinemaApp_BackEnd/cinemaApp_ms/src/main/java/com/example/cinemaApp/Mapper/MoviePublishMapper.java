package com.example.cinemaApp.Mapper;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
import com.example.cinemaApp.DTO.ShowDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Entity.Seats;
import com.example.cinemaApp.Entity.Show;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import com.example.cinemaApp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MoviePublishMapper {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private ShowRepository showRepository;

    public MoviePublishDTO mapIn(Movie movie, int id){
        MoviePublishDTO temp = new MoviePublishDTO();

        temp.setMovieID(movie.getMovieID());
        temp.setMovieName(movie.getMovieName());
        temp.setDescription(movie.getDescription());
        temp.setDurationMinutes(movie.getDurationMinutes());
        temp.setImgURL(movie.getImgURL());
        temp.setLanguage(movie.getLanguage());
        temp.setReleaseDate(movie.getReleaseDate());

        Optional<CinemaUser> cinemaUsers = cinemaUserRepository.findById(id);

        if (cinemaUsers.isPresent()) {

            CinemaUser cinemaUser = (CinemaUser) cinemaUsers.get();

            List<Show> shows = showRepository.findByMovie(movie);

            List<ShowDTO> showDTOs = new ArrayList<>();

            for (Show originalShow : shows) {
                ShowDTO simplifiedShow = new ShowDTO();

                simplifiedShow.setShowID(originalShow.getShowID());
                simplifiedShow.setShowDate(originalShow.getShowDate());
                simplifiedShow.setShowTime(originalShow.getShowTime());
                simplifiedShow.setAvailableSeatCount(originalShow.getAvailableSeatCount());
                simplifiedShow.setSeatCategory(originalShow.getSeatCategory().getType());

                showDTOs.add(simplifiedShow);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println(showDTOs);
            temp.setCinemaUser(cinemaUser);
            temp.setShows(showDTOs);

            return temp;
        } else {
            System.out.println("Cinema Uset Cannot be found!");
            return null;
        }

    }

}
