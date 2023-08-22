package com.example.cinemaApp.DTO;

import com.example.cinemaApp.Entity.CinemaUser;
import java.time.LocalDate;
import java.util.List;

public class MovieDTO {


    private int movieID;
    private String movieName;
    private String description;
    private String language;
    private int durationMinutes;
    private LocalDate releaseDate;
    private String imgURL;
    private List<String> showDates;
    private List<String> showTimes;
    private CinemaUser cinemaUser;

    public MovieDTO(int movieID, String movieName, String description, String language, int durationMinutes, LocalDate releaseDate, String imgURL, List<String> showDates, List<String> showTimes, CinemaUser cinemaUser) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.description = description;
        this.language = language;
        this.durationMinutes = durationMinutes;
        this.releaseDate = releaseDate;
        this.imgURL = imgURL;
        this.showDates = showDates;
        this.showTimes = showTimes;
        this.cinemaUser = cinemaUser;
    }

    public MovieDTO() {
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public List<String> getShowDates() {
        return showDates;
    }

    public void setShowDates(List<String> showDates) {
        this.showDates = showDates;
    }

    public List<String> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<String> showTimes) {
        this.showTimes = showTimes;
    }

    public CinemaUser getCinemaUser() {
        return cinemaUser;
    }

    public void setCinemaUser(CinemaUser cinemaUser) {
        this.cinemaUser = cinemaUser;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", releaseDate=" + releaseDate +
                ", imgURL='" + imgURL + '\'' +
                ", showDates=" + showDates +
                ", showTimes=" + showTimes +
                ", cinemaUser=" + cinemaUser +
                '}';
    }
}
