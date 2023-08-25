package com.example.cinemaApp.Repository;

import com.example.cinemaApp.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findById (int movieID);

}
