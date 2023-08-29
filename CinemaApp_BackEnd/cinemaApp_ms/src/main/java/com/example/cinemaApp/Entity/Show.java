package com.example.cinemaApp.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showID;

    @ManyToOne
    @JoinColumn(name = "movieID")
    private Movie movie;

    private String showDate;

    private String showTime;

    @ManyToOne
    @JoinColumn(name = "id")
    private Seats seatCategory;

    private int availableSeatCount;

    public Show() {
    }

    public Show(long showID, Movie movie, String showDate, String showTime, Seats seatCategory, int availableSeatCount) {
        this.showID = showID;
        this.movie = movie;
        this.showDate = showDate;
        this.showTime = showTime;
        this.seatCategory = seatCategory;
        this.availableSeatCount = availableSeatCount;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public long getShowID() {
        return showID;
    }

    public void setShowID(long showID) {
        this.showID = showID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public Seats getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(Seats seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getAvailableSeatCount() {
        return availableSeatCount;
    }

    public void setAvailableSeatCount(int availableSeatCount) {
        this.availableSeatCount = availableSeatCount;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showID=" + showID +
                ", movie=" + movie +
                ", showDate='" + showDate + '\'' +
                ", showTime='" + showTime + '\'' +
                ", seatCategory=" + seatCategory +
                ", availableSeatCount=" + availableSeatCount +
                '}';
    }
}

