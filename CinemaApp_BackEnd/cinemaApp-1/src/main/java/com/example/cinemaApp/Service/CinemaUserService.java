package com.example.cinemaApp.Service;

import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public interface CinemaUserService {
    public String register(CinemaUserDTO cinemaUserDTO);

}
