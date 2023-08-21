package com.example.cinemaApp.Service;

import com.example.cinemaApp.DTO.SeatsDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope
public interface SeatService {

    int saveSeat(SeatsDTO seatsDTO);
}
