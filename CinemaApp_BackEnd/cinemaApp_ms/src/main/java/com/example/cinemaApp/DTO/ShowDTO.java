package com.example.cinemaApp.DTO;

public class ShowDTO {

    private long showID;
    private String showDate;
    private String showTime;
    private String seatCategory;
    private int availableSeatCount;

    public ShowDTO(long showID, String showDate, String showTime, String seatCategory, int availableSeatCount) {
        this.showID = showID;
        this.showDate = showDate;
        this.showTime = showTime;
        this.seatCategory = seatCategory;
        this.availableSeatCount = availableSeatCount;
    }

    public ShowDTO() {
    }

    public long getShowID() {
        return showID;
    }

    public void setShowID(long showID) {
        this.showID = showID;
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

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
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
        return "ShowDTO{" +
                "showID=" + showID +
                ", showDate='" + showDate + '\'' +
                ", showTime='" + showTime + '\'' +
                ", seatCategory='" + seatCategory + '\'' +
                ", availableSeatCount=" + availableSeatCount +
                '}';
    }
}
