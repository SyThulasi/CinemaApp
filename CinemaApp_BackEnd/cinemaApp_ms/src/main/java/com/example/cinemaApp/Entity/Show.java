package com.example.cinemaApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showID;

    @ManyToOne
    @JoinColumn(name = "movieID")
    private Movie movie;

    private String showDate;

    private String showTime;

    @JsonIgnore
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<SeatCategory> seatCategory = new ArrayList<>();


    public Show() {
    }

    public Show(long showID, Movie movie, String showDate, String showTime, List<SeatCategory> seatCategory) {
        this.showID = showID;
        this.movie = movie;
        this.showDate = showDate;
        this.showTime = showTime;
        this.seatCategory = seatCategory;
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

    public List<SeatCategory> getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(List<SeatCategory> seatCategory) {
        this.seatCategory = seatCategory;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showID=" + showID +
                ", movie=" + movie +
                ", showDate='" + showDate + '\'' +
                ", showTime='" + showTime + '\'' +
                ", seatCategory=" + seatCategory +
                '}';
    }
}

