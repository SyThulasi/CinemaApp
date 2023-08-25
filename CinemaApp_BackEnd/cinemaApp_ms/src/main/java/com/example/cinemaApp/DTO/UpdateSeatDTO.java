package com.example.cinemaApp.DTO;

public class UpdateSeatDTO {

    private Long id;
    private String type;
    private int count;
    private double price;

    public UpdateSeatDTO(Long id, String type, int count, double price) {
        this.id = id;
        this.type = type;
        this.count = count;
        this.price = price;
    }

    public UpdateSeatDTO() {
    }

    public Integer getId() {
        return Math.toIntExact(id);
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
}
