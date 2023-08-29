package com.example.cinemaApp.Repository;

import com.example.cinemaApp.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatCategoryRepository extends JpaRepository<SeatCategory, Long> {

    List<SeatCategory> findByShow(Show show);
}
