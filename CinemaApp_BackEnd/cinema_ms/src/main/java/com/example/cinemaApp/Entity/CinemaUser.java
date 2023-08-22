package com.example.cinemaApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CinemaUser")
public class CinemaUser {

    @Id
    @Column(name = "cinema_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaId;
    @Column(name = "cinema_name", length = 255)
    private String cinemaName;
    @Column(name = "city", length = 255)
    private String city;
    @Column(name = "phone_number", length = 255)
    private String phoneNo;
    @Column(name = "cinema_username", length = 255)
    private String userName;
    @Column(name = "password", length = 255)
    private String password;

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
