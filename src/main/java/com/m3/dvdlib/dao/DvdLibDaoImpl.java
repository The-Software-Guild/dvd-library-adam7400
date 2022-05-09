package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;
import org.apache.commons.collections4.list.TreeList;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DvdLibDaoImpl implements DvdLibDao {

    private Map<String, Dvd> dvds = new HashMap<>(); // map for searching dvd by title
    public static final String MOVIEDB_FILE = "movieDb.txt";
    public static final String DELIMITER = "::";

    @Override
    public void addDvd(Dvd dvd) {
        dvds.put(dvd.getMovieTitle(), dvd); // key is title
    }

    @Override
    public Dvd removeDvd(String movieTitle) {
        return dvds.remove(movieTitle);
    }

    @Override
    public List<Dvd> listAllDvds() {
        return new TreeList<Dvd>(dvds.values());
    }

    @Override
    public Dvd accessDvdInfo(String movieTitle) {
        return dvds.get(movieTitle);
    }

    @Override
    public Dvd unmarshallDvd(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String movieTitle = dvdTokens[0];
        String mpa = dvdTokens[1];
        String date = dvdTokens[2];
        String director = dvdTokens[3];
        String studio = dvdTokens[4];
        Dvd dvdFromFile = new Dvd(movieTitle, mpa, date, director, studio);
        dvdFromFile.setUserNote(dvdTokens[5]);
        return dvdFromFile;
    }

    @Override
    public List<Dvd> lastNyearsMovies(int n) {
        return null;
    }

    @Override
    public List<Dvd> moviesWithMPA(String mpa) {
        return dvds.values().stream()
                .filter((dvd) -> dvd.getmPAArating().equals(mpa))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> moviesWithDirector(String directorName) {
        return dvds.values().stream()
                .filter((dvd) -> dvd.getDirectorName().equals(directorName))
                .collect(Collectors.toList());
    }

    // use map method, need to change the date format to date - so you can use get year etc.
    @Override
    public double avgAgeOfMovies() {
        return 0;
    }

    @Override
    public String oldestMovie() {
        return null;
    }

    @Override
    public double avgNoOfNotes() {
        return 0;
    }


}


