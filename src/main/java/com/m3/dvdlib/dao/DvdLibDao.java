package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;

import java.util.List;
import java.util.Scanner;

public interface DvdLibDao {

    void addDvd(Dvd dvd);

    Dvd removeDvd(String movieTitle);

    List<Dvd> listAllDvds();

    Dvd accessDvdInfo(String movieTitle);

    Dvd unmarshallDvd(String dvdAsText);

    List<Dvd> lastNyearsMovies(int n);

    List<Dvd> moviesWithMPA(String mpa);

    List<Dvd> moviesWithDirector(String directorName);

    double avgAgeOfMovies();

    String oldestMovie();

    double avgNoOfNotes();




}
