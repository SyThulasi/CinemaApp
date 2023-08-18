package com.example.cinemaApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SeatType")
public class SeatType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int count;
    private double price;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaUser cinemaUser;



}
