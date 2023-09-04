package com.example.cinemaApp.Repository;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long>{
    List<Show> findByMovie(Movie movie);

    Optional<Show> findById(Long id);

    Show findByShowID(Long showID);
}
