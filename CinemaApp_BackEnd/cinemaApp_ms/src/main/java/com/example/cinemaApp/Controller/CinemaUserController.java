package com.example.cinemaApp.Controller;


import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import com.example.cinemaApp.Service.CinemaUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


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
    public Object loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        CinemaUser cinemaUser = cinemaUserService.loginEmployee(loginDTO);


        Map<String, Object> userRet = new HashMap<>();
        userRet.put("cinemaId", cinemaUser.getCinemaId());
        userRet.put("cinemaName", cinemaUser.getCinemaName());
        userRet.put("city", cinemaUser.getCity());
        userRet.put("phoneNo", cinemaUser.getPhoneNo());
        userRet.put("userName", cinemaUser.getUserName());


        return userRet;
    }

    @PutMapping("/save")
    //@RequestParam("id") int id,
    public CinemaUser updateProfile(@RequestBody CinemaUserDTO cinemaUserDTO){

        return cinemaUserService.updateProfile(cinemaUserDTO);
    }


}
