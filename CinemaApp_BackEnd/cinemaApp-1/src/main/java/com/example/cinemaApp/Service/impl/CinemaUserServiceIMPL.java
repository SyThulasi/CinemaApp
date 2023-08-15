package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import com.example.cinemaApp.Service.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Scope
@Service
public class CinemaUserServiceIMPL implements CinemaUserService {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(CinemaUserDTO cinemaUserDTO) {
        CinemaUser cinemaUser = new CinemaUser(

                cinemaUserDTO.getCinemaId(),
                cinemaUserDTO.getCinemaName(),
                cinemaUserDTO.getCity(),
                cinemaUserDTO.getPhoneNo(),
                cinemaUserDTO.getUserName(),
                this.passwordEncoder.encode(cinemaUserDTO.getPassword())

        );
        cinemaUserRepository.save(cinemaUser);
        return cinemaUser.getCinemaName();
    }


}
