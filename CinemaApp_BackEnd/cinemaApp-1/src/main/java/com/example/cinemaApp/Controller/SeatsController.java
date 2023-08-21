package com.example.cinemaApp.Controller;


import com.example.cinemaApp.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cinemaApp.DTO.SeatsDTO;

@RestController
@RequestMapping("api/v1/Seats")
@CrossOrigin
public class SeatsController {

    @Autowired
    private SeatService seatService;

    @Autowired
    public SeatsController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping(path = "/save")
    public  int saveSeatType(@RequestBody SeatsDTO seatsDTO){

        int id = seatService.saveSeat(seatsDTO);
        return id;
    }

}
