package com.example.cinemaApp.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showID;

    private LocalDate showDate;
    private LocalDate showTime;



}
