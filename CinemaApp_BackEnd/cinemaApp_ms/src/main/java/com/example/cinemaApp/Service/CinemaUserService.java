package com.example.cinemaApp.Service;

import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope
public interface CinemaUserService {
    public String register(CinemaUserDTO cinemaUserDTO);

    Optional<CinemaUser> loginEmployee(LoginDTO loginDTO);


    CinemaUser updateProfile(CinemaUserDTO cinemaUserDTO, int id);
}
