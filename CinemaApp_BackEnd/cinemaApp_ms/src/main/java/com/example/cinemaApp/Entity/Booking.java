package com.example.cinemaApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    private long bookingID;

    private int noOfBookedSeats;
    private  String seatCategory;
    private  Long showID;

    @ManyToOne
    @JoinColumn(name = "movie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    public Booking(long bookingID, int noOfBookedSeats, String seatCategory, Long showID, Movie movie, Customer customer) {
        this.bookingID = bookingID;
        this.noOfBookedSeats = noOfBookedSeats;
        this.seatCategory = seatCategory;
        this.showID = showID;
        this.movie = movie;
        this.customer = customer;
    }

    public Booking() {
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public int getNoOfBookedSeats() {
        return noOfBookedSeats;
    }

    public void setNoOfBookedSeats(int noOfBookedSeats) {
        this.noOfBookedSeats = noOfBookedSeats;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public Long getShowID() {
        return showID;
    }

    public void setShowID(Long showID) {
        this.showID = showID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", noOfBookedSeats=" + noOfBookedSeats +
                ", seatCategory='" + seatCategory + '\'' +
                ", showID=" + showID +
                ", movie=" + movie +
                ", customer=" + customer +
                '}';
    }
}
