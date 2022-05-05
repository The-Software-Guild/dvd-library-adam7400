package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;

import java.util.List;
import java.util.Scanner;

public interface DvdLibDao {

    void addDvd(Dvd dvd);

    Dvd removeDvd(String movieTitle);

    List<Dvd> listAllDvdTitles();

    Dvd accessDvdInfo(String movieTitle);

    Scanner readFromDb(String filePath);

    void writeToDb(String dvdInfo);







}
