package com.m3.dvdlib.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Dvd {
    private String movieTitle;
    private LocalDate releaseDate;
    private String mPArating;
    private String directorName;
    private String studioName;
    private String userNote;


    public String getMovieTitle() {
        return movieTitle;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getmPAArating() {
        return mPArating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getStudioName() {
        return studioName;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setReleaseDate(String date) {
        String[] arr =  date.split("/");
        Integer year = Integer.valueOf(arr[2]);
        Integer month = Integer.valueOf(arr[1]);
        Integer day = Integer.valueOf(arr[0]);
        this.releaseDate = LocalDate.of(year, month, day);
        // catch the exception


    }

    public void setmPAArating(String mPArating) {
        this.mPArating = mPArating;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dvd dvd = (Dvd) o;
        return Objects.equals(movieTitle, dvd.movieTitle) &&
                Objects.equals(releaseDate, dvd.releaseDate) &&
                Objects.equals(mPArating, dvd.mPArating) &&
                Objects.equals(directorName, dvd.directorName) &&
                Objects.equals(studioName, dvd.studioName);
    }

    @Override
    public String toString() {
        return "\nMovie title: " + movieTitle +
                "\nRelease date: " + releaseDate +
                "\nMPAA rating: " + mPArating +
                "\nDirector: " + directorName +
                "\nStudio: " + studioName +
                "\nUser note: " + userNote;

    }
}

