package com.example.cinemaApp.DTO;

import com.example.cinemaApp.Entity.CinemaUser;
import com.example.cinemaApp.Entity.Show;

import java.time.LocalDate;
import java.util.List;

public class MoviePublishDTO {

    private int movieID;
    private String movieName;
    private String description;
    private String language;
    private int durationMinutes;
    private LocalDate releaseDate;
    private String imgURL;
    private CinemaUser cinemaUser;
    private List<ShowDTO> shows;

    public MoviePublishDTO(int movieID, String movieName, String description, String language, int durationMinutes, LocalDate releaseDate, String imgURL, CinemaUser cinemaUser, List<ShowDTO> shows) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.description = description;
        this.language = language;
        this.durationMinutes = durationMinutes;
        this.releaseDate = releaseDate;
        this.imgURL = imgURL;
        this.cinemaUser = cinemaUser;
        this.shows = shows;
    }

    public MoviePublishDTO() {
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

    public CinemaUser getCinemaUser() {
        return cinemaUser;
    }

    public void setCinemaUser(CinemaUser cinemaUser) {
        this.cinemaUser = cinemaUser;
    }

    public List<ShowDTO> getShows() {
        return shows;
    }

    public void setShows(List<ShowDTO> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "MoviePublishDTO{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", releaseDate=" + releaseDate +
                ", imgURL='" + imgURL + '\'' +
                ", cinemaUser=" + cinemaUser +
                ", shows=" + shows +
                '}';
    }
}
