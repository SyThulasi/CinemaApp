package com.example.cinemaApp.Repository;

import com.example.cinemaApp.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
