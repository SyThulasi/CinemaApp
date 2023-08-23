package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.SeatsDTO;
import com.example.cinemaApp.Entity.Seats;
import com.example.cinemaApp.Repository.SeatsRepository;
import com.example.cinemaApp.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Scope
@Service
public class SeatServiceIMPL implements SeatService {

    @Autowired
    private SeatsRepository seatsRepository;

    @Override
    public int saveSeat(SeatsDTO seatsDTO) {

        Seats seats = new Seats(
                seatsDTO.getId(),
                seatsDTO.getType(),
                seatsDTO.getCount(),
                seatsDTO.getPrice(),
                seatsDTO.getCinemaUser()
        );
        seatsRepository.save(seats);
        return Math.toIntExact(seats.getId());
    }
}
