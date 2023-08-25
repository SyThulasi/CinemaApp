package com.example.cinemaApp.Mapper;

import com.example.cinemaApp.DTO.MovieDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieMapper {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;



    public Movie mapIn(MovieDTO movieDTO){
        Movie temp = new Movie();

        temp.setMovieName(movieDTO.getMovieName());
        temp.setDescription(movieDTO.getDescription());
        temp.setDurationMinutes(movieDTO.getDurationMinutes());
        temp.setImgURL(movieDTO.getImgURL());
        temp.setLanguage(movieDTO.getLanguage());
        temp.setReleaseDate(movieDTO.getReleaseDate());
        temp.setShowDates(movieDTO.getShowDates());
        temp.setShowTimes(movieDTO.getShowTimes());

        Optional<CinemaUser> cinemaUsers = cinemaUserRepository.findById(movieDTO.getCinemaId());


        if (cinemaUsers.isPresent()) {

            CinemaUser cinemaUser = (CinemaUser) cinemaUsers.get();
            temp.setCinemaUser(cinemaUser);
            System.out.println(temp);

            return temp;
        } else {
            System.out.println("Cinema Uset Cannot be found!");
            return null;
        }

    }

}
