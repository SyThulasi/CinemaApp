package com.example.cinemaApp.Repository;
import com.example.cinemaApp.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface SeatsRepository extends JpaRepository<Seats,Integer> {



}
