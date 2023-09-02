package com.example.cinemaApp.Controller;


import com.example.cinemaApp.DTO.UpdateSeatDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Seats;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import com.example.cinemaApp.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cinemaApp.DTO.SeatsDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cinemaUser/Seats")
@CrossOrigin( allowedHeaders = {})
public class SeatsController {

    @Autowired
    private SeatService seatService;

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    public SeatsController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping(path = "/save")
    public Seats saveSeatType(@RequestBody SeatsDTO seatsDTO){

        seatService.saveSeat(seatsDTO);
        return null;
    }

    @PutMapping("/save")
    public Seats updateSeat(@RequestBody UpdateSeatDTO updateSeatDTO) {
        return seatService.updateSeat(updateSeatDTO);
    }

    @GetMapping("/save/Seats/{cinemaId}")
    public List<Seats> getSeatsFromCinema(@PathVariable("cinemaId") int cinemaId){
        Optional<CinemaUser> cinemaUser = cinemaUserRepository.findById(cinemaId);
        return seatService.getSeatsFromCinema(cinemaUser.get());
    }
}
