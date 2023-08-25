package com.example.cinemaApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CinemaUser")
public class CinemaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaId;
    private String cinemaName;
    private String city;
    private String phoneNo;
    private String userName;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "cinemaUser", cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cinemaUser", cascade = CascadeType.ALL)
    private List<Seats> seatCategory = new ArrayList<>();


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public CinemaUser(int cinemaId, String cinemaName, String city, String phoneNo, String userName, String password) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.city = city;
        this.phoneNo = phoneNo;
        this.userName = userName;
        this.password = password;
    }

    public CinemaUser() {
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }
    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CinemaUser{" +
                "cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", city='" + city + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
