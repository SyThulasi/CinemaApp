package com.example.cinemaApp.Repository;

import com.example.cinemaApp.Entity.Booking;
import com.example.cinemaApp.Entity.Movie;
import com.example.cinemaApp.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByShowID(Long showID);
}
