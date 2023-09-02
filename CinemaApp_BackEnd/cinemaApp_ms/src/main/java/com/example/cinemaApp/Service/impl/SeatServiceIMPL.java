package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.SeatsDTO;
import com.example.cinemaApp.DTO.UpdateSeatDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Seats;
import com.example.cinemaApp.Mapper.SeatsMapper;
import com.example.cinemaApp.Repository.SeatsRepository;
import com.example.cinemaApp.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Scope
@Service
public class SeatServiceIMPL implements SeatService {

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private SeatsMapper seatsMapper;

    @Override
    public Seats saveSeat(SeatsDTO seatsDTO) {

        Seats seats = new Seats();

        seats = seatsMapper.mapIn(seatsDTO);
        seatsRepository.save(seats);
        return seats;
    }

    @Override
    public Seats updateSeat(UpdateSeatDTO updateSeatDTO) {
        Optional seat=seatsRepository.findById(updateSeatDTO.getId());

        if(seat.isPresent()){
            Seats seatEntity=(Seats) seat.get();
            seatEntity.setPrice(updateSeatDTO.getPrice());
            seatEntity.setCount(updateSeatDTO.getCount());
            seatEntity.setType(updateSeatDTO.getType());
            seatsRepository.save(seatEntity);
            return seatEntity;
        }
        return null;
    }

    @Override
    public List<Seats> getSeatsFromCinema(CinemaUser cinemaUser) {
        return seatsRepository.findByCinemaUser(cinemaUser);
    }
}
