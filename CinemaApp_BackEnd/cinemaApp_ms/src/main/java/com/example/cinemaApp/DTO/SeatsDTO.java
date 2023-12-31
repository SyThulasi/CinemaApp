package com.example.cinemaApp.DTO;

import com.example.cinemaApp.Entity.CinemaUser;

public class SeatsDTO {

    private Long id;
    private String type;
    private int count;
    private double price;
    private int cinemaId;

    public SeatsDTO(Long id, String type, int count, double price, int cinemaId) {
        this.id = id;
        this.type = type;
        this.count = count;
        this.price = price;
        this.cinemaId = cinemaId;
    }

    public SeatsDTO() {
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

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }
}
