package com.example.cinemaApp.Service.impl;

import Responce.LoginResponse;
import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import com.example.cinemaApp.Service.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
    CinemaUserDTO cinemaUserDTO;
    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        CinemaUser cinemaUser1 = cinemaUserRepository.findByUserName(loginDTO.getUserName());
        if (cinemaUser1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = cinemaUser1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<CinemaUser> cinemaUser = cinemaUserRepository.findOneByUserNameAndPassword(loginDTO.getUserName(), encodedPassword);
                if (cinemaUser.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("User not exits", false);
        }
    }


}
