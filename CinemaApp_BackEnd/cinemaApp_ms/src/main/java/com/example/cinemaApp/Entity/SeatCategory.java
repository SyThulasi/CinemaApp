package com.example.cinemaApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SeatCategory")
public class SeatCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatcategoryID;

    private String type;
    private int availableSeatCount;

    @ManyToOne
    @JoinColumn(name = "showID")
    private Show show;

    public SeatCategory(long seatcategoryID, String type, int availableSeatCount, Show show) {
        this.seatcategoryID = seatcategoryID;
        this.type = type;
        this.availableSeatCount = availableSeatCount;
        this.show = show;
    }


    public SeatCategory() {
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

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public long getSeatcategoryID() {
        return seatcategoryID;
    }

    public void setSeatcategoryID(long seatcategoryID) {
        this.seatcategoryID = seatcategoryID;
    }

    @Override
    public String toString() {
        return "SeatCategory{" +
                "seatcategoryID=" + seatcategoryID +
                ", type='" + type + '\'' +
                ", availableSeatCount=" + availableSeatCount +
                ", show=" + show +
                '}';
    }
}
