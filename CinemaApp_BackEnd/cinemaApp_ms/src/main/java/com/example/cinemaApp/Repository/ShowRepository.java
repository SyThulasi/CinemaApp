package com.example.cinemaApp.Repository;
import com.example.cinemaApp.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long>{
}
