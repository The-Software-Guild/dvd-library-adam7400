package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;
import org.apache.commons.collections4.list.TreeList;

import java.io.*;
import java.util.*;

public class DvdLibDaoImpl implements DvdLibDao {

    private Map<String, Dvd> dvds = new HashMap<>(); // map for searching dvd by title

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
    public Scanner readFromFile(String filePath) {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));
            return sc;
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return null;
    }

    @Override
    public void writeToFile(String filePath) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(filePath));
            for (Dvd dvd : dvds.values()) {
                out.println(dvd.getMovieTitle());
                out.println(dvd.getReleaseDate());
                out.println(dvd.getmPAArating());
                out.println(dvd.getDirectorName());
                out.println(dvd.getStudioName());
                out.println(dvd.getUserNote());
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("An exception has occurred.");
        }


    }
}


