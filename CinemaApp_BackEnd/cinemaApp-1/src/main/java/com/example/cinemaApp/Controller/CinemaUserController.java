package com.example.cinemaApp.Controller;


import Responce.LoginResponce;
import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import com.example.cinemaApp.Service.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/cinemaUser")
@CrossOrigin( origins = "http://localhost:3000/", allowedHeaders = {})
public class CinemaUserController {

    @Autowired
    private CinemaUserService cinemaUserService;

    @PostMapping(path = "/save")
    public String registerUser(@RequestBody CinemaUserDTO cinemaUserDTO){
        return cinemaUserService.register(cinemaUserDTO);
    }


}
