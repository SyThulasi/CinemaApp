package com.example.cinemaApp.Mapper;

import com.example.cinemaApp.DTO.SeatsDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Seats;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class SeatsMapper {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;



    public Seats mapIn(SeatsDTO seatsDTO){
        Seats temp = new Seats();

        temp.setType(seatsDTO.getType());
        temp.setCount(seatsDTO.getCount());
        temp.setPrice(seatsDTO.getPrice());

        Optional<CinemaUser> cinemaUsers = cinemaUserRepository.findById(seatsDTO.getCinemaId());


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
