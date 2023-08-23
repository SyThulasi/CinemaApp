package com.example.cinemaApp.Repository;

import com.example.cinemaApp.Entity.CinemaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CinemaUserRepository extends JpaRepository<CinemaUser,Integer> {

    CinemaUser findByUserName(String userName);

    Optional<CinemaUser> findOneByUserNameAndPassword(String userName, String encodedPassword);

    Optional <CinemaUser> findById(int cinemaId);

}
