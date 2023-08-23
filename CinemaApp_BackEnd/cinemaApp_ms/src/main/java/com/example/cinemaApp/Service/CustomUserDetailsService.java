package com.example.cinemaApp.Service;


import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Repository.CinemaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
       final CinemaUser cinemaUser = cinemaUserRepository.findByUserName(userName);
        if (cinemaUser == null) {
            throw new UsernameNotFoundException(userName);
        }
        System.out.println(cinemaUser);
        return new CustomUserDetails(cinemaUser);
    }
}
