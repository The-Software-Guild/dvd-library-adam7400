package com.m3.dvdlib.dto;

public class Dvd {
    private String dvdId;
    private String movieTitle;
    private String releaseDate;
    private String mPAArating;
    private String directorName;
    private String studioName;
    private String userNote;


    public Dvd(String movieTitle, String releaseDate, String mPAArating, String directorName, String studioName){
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.mPAArating = mPAArating;
        this.directorName = directorName;
        this.studioName = studioName;
    }

    public Dvd(String dvdId) {
        this.dvdId = dvdId;
    }
    
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public String getTitle() {
        return movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getmPAArating() {
        return mPAArating;
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

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setmPAArating(String mPAArating) {
        this.mPAArating = mPAArating;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getDvdId() {
        return dvdId;
    }

    public void setDvdId(String dvdId) {
        this.dvdId = dvdId;
    }
}

