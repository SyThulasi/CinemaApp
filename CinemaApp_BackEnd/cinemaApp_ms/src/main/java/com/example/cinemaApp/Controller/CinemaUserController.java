package com.example.cinemaApp.Controller;


import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Responce.LoginResponse;
import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import com.example.cinemaApp.Service.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/v1/cinemaUser/user")
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = {"Access-Control-Allow-Origin"})
public class CinemaUserController {

    @Autowired
    private CinemaUserService cinemaUserService;


    @PostMapping(path = "/save")
    public String registerUser(@RequestBody CinemaUserDTO cinemaUserDTO){
        return cinemaUserService.register(cinemaUserDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
//        LoginResponse loginResponse = cinemaUserService.loginEmployee(loginDTO);
        Optional<CinemaUser> cinemaUser = cinemaUserService.loginEmployee(loginDTO);
        return ResponseEntity.ok(cinemaUser);
    }

    @PutMapping("/save/{id}")
    public CinemaUser updateProfile(@RequestParam("id") int id, CinemaUserDTO cinemaUserDTO){
        return cinemaUserService.updateProfile(cinemaUserDTO,id);
    }


}
