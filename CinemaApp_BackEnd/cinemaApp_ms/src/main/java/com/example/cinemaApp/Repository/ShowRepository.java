package com.example.cinemaApp.Repository;
import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Entity.Seats;
import com.example.cinemaApp.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long>{
    List<Show> findByMovie(Movie movie);
}
