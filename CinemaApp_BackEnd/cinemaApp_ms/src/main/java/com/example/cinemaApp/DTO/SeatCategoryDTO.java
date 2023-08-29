package com.example.cinemaApp.DTO;

public class SeatCategoryDTO {

    private String type;
    private int availableSeatCount;

    public SeatCategoryDTO( String type, int availableSeatCount) {
        this.type = type;
        this.availableSeatCount = availableSeatCount;
    }

    public SeatCategoryDTO() {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAvailableSeatCount() {
        return availableSeatCount;
    }

    public void setAvailableSeatCount(int availableSeatCount) {
        this.availableSeatCount = availableSeatCount;
    }

    @Override
    public String toString() {
        return "SeatCategory{" +
                ", type='" + type + '\'' +
                ", availableSeatCount=" + availableSeatCount +
                '}';
    }
}
