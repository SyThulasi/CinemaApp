package com.example.cinemaApp.DTO;


public class BookingRequestDTO {

    private int bookingID;
    private int customerID;
    private int  noOfBookedSeats;
    private String name;
    private String customerEmail;
    private long showId;
    private String seatCategory;

    public BookingRequestDTO(int bookingID, int customerID, int noOfBookedSeats, String name, String customerEmail, long showId, String seatCategory) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.noOfBookedSeats = noOfBookedSeats;
        this.name = name;
        this.customerEmail = customerEmail;
        this.showId = showId;
        this.seatCategory = seatCategory;
    }

    public BookingRequestDTO() {
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getNoOfBookedSeats() {
        return noOfBookedSeats;
    }

    public void setNoOfBookedSeats(int noOfBookedSeats) {
        this.noOfBookedSeats = noOfBookedSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    @Override
    public String toString() {
        return "BookingRequestDTO{" +
                "bookingID=" + bookingID +
                ", customerID=" + customerID +
                ", noOfBookedSeats=" + noOfBookedSeats +
                ", name='" + name + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", showId=" + showId +
                ", seatCategory='" + seatCategory + '\'' +
                '}';
    }
}
