package com.example.cinemaApp.Repository;

import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findById (int movieID);

    public List<Movie> findByCinemaUser(CinemaUser cinemaUser);

}
