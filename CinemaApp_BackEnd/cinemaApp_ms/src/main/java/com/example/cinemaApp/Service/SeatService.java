package com.example.cinemaApp.Service;

import com.example.cinemaApp.DTO.SeatsDTO;
import com.example.cinemaApp.DTO.UpdateSeatDTO;
import com.example.cinemaApp.Entity.Seats;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope
public interface SeatService {

    Seats saveSeat(SeatsDTO seatsDTO);

    Seats updateSeat(UpdateSeatDTO updateSeatDTO);
}
