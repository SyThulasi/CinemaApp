package com.example.cinemaApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Seats")
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int count;
    private double price;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaUser cinemaUser;

    public Seats(Long id, String type, int count, double price, CinemaUser cinemaUser) {
        this.id = id;
        this.type = type;
        this.count = count;
        this.price = price;
        this.cinemaUser = cinemaUser;
    }

    public Seats() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CinemaUser getCinemaUser() {
        return cinemaUser;
    }

    public void setCinemaUser(CinemaUser cinemaUser) {
        this.cinemaUser = cinemaUser;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", cinemaUser=" + cinemaUser +
                '}';
    }
}
