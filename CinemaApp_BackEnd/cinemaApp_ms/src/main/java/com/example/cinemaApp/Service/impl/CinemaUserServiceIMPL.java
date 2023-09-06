package com.example.cinemaApp.Service.impl;

import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.LoginDTO;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Mapper.CinemaUserMapper;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import com.example.cinemaApp.Service.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope
@Service
public class CinemaUserServiceIMPL implements CinemaUserService {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CinemaUserMapper cinemaUserMapper;

    @Override
    public ResponseEntity<?> register(CinemaUserDTO cinemaUserDTO) {

        if(cinemaUserRepository.findByUserName(cinemaUserDTO.getUserName()) != null){
            String errorMessage = "UserName address already exists";
            return ResponseEntity.badRequest().body(errorMessage);
            // throw new UserAlreadyExistException("User already exists for this email");
        }
        CinemaUser cinemaUser = new CinemaUser(

                cinemaUserDTO.getCinemaId(),
                cinemaUserDTO.getCinemaName(),
                cinemaUserDTO.getCity(),
                cinemaUserDTO.getPhoneNo(),
                cinemaUserDTO.getUserName(),
                this.passwordEncoder.encode(cinemaUserDTO.getPassword())

        );
        cinemaUserRepository.save(cinemaUser);
        return ResponseEntity.ok(cinemaUserDTO.getUserName());
    }
    CinemaUserDTO cinemaUserDTO;

    @Override
    public ResponseEntity<?> loginEmployee(@CurrentSecurityContext(expression="authentication?.name")LoginDTO loginDTO) {
        String msg = "";
        CinemaUser cinemaUser1 = cinemaUserRepository.findByUserName(loginDTO.getUserName());
        if (cinemaUser1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = cinemaUser1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwdRight){
                CinemaUser cinemaUser = cinemaUserRepository.findOneByUserNameAndPassword(loginDTO.getUserName(), encodedPassword);
                Map<String, Object> userRet = new HashMap<>();
                userRet.put("cinemaId", cinemaUser.getCinemaId());
                userRet.put("cinemaName", cinemaUser.getCinemaName());
                userRet.put("city", cinemaUser.getCity());
                userRet.put("phoneNo", cinemaUser.getPhoneNo());
                userRet.put("userName", cinemaUser.getUserName());
                return ResponseEntity.ok(userRet);
            }
            else {
                System.out.println("Incorrect Password...!");
                return ResponseEntity.badRequest().body("Incorrect Password...!");
            }
        }else {
            System.out.println("User Not Exist...!");
           return ResponseEntity.badRequest().body("User Not Exist...!");
        }

    }

    @Override
    public CinemaUser updateProfile(CinemaUserDTO cinemaUserDTO) {
        CinemaUser cinemaUserEntity =new CinemaUser();
        cinemaUserEntity = cinemaUserMapper.mapIn(cinemaUserDTO);
        cinemaUserEntity.setCinemaId(cinemaUserDTO.getCinemaId());
        cinemaUserEntity.setPassword(this.passwordEncoder.encode(cinemaUserDTO.getPassword()));
        cinemaUserRepository.save(cinemaUserEntity);

        System.out.println("Edited Succesfully");
        return cinemaUserEntity;
    }


}
