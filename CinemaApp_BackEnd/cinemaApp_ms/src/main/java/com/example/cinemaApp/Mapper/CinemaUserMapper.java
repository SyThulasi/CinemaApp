package com.example.cinemaApp.Mapper;


import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CinemaUserMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;
    public CinemaUser mapIn(CinemaUserDTO cinemaUserDTO){
        CinemaUser temp = new CinemaUser();
        temp.setCinemaName(cinemaUserDTO.getCinemaName());
        temp.setCity(cinemaUserDTO.getCity());
        temp.setPhoneNo(cinemaUserDTO.getPhoneNo());
        temp.setUserName(cinemaUserDTO.getUserName());
        temp.setPassword(encodePassword(cinemaUserDTO));
        return temp;
    }

    public CinemaUserDTO mapOut(CinemaUser cinemaUserEntity){
        CinemaUserDTO temp = new CinemaUserDTO();
        temp.setCinemaName(cinemaUserEntity.getCinemaName());
        temp.setCity(cinemaUserEntity.getCity());
        temp.setPhoneNo(cinemaUserEntity.getPhoneNo());
        temp.setUserName(cinemaUserEntity.getUserName());
//        temp.setPassword(cinemaUserEntity.getPassword());
        return temp;
    }

    public String encodePassword(CinemaUserDTO source){
        String encodedPassword = passwordEncoder.encode(source.getPassword());
       return encodedPassword;
    }
}
