package com.example.cinemaApp.Controller;


import Responce.LoginResponse;
import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import com.example.cinemaApp.Service.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/cinemaUser")
@CrossOrigin
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
        LoginResponse loginResponse = cinemaUserService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
