package com.example.cinemaApp.DTO;

import com.example.cinemaApp.Entity.SeatCategory;

import java.util.List;

public class ShowDTO {

    private long showID;
    private String showDate;
    private String showTime;

    private List<SeatCategoryDTO> seatCategoryDTO;

    public ShowDTO(long showID, String showDate, String showTime, List<SeatCategoryDTO> seatCategoryDTO) {
        this.showID = showID;
        this.showDate = showDate;
        this.showTime = showTime;
        this.seatCategoryDTO = seatCategoryDTO;
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

    public List<SeatCategoryDTO> getSeatCategoryDTO() {
        return seatCategoryDTO;
    }

    public void setSeatCategoryDTO(List<SeatCategoryDTO> seatCategoryDTO) {
        this.seatCategoryDTO = seatCategoryDTO;
    }

    @Override
    public String toString() {
        return "ShowDTO{" +
                "showID=" + showID +
                ", showDate='" + showDate + '\'' +
                ", showTime='" + showTime + '\'' +
                ", seatCategoryDTO=" + seatCategoryDTO +
                '}';
    }
}
