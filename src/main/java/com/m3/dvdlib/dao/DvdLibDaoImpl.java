package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class DvdLibDaoImpl implements DvdLibDao{

    private Map<String, Dvd> dvds = new HashMap<>();
    private Map<String, Dvd> dvds2 = new HashMap<>(); // map for searching dvd by title

    @Override
    public void addDvd(Dvd dvd) {
        dvds.put(dvd.getDvdId(), dvd);  // key is id
        dvds2.put(dvd.getTitle(), dvd); // key is title
    }

    @Override
    public Dvd removeDvd(String dvdId) {
        return dvds.remove(dvdId);
    }


    @Override
    public Dvd editDvdInfo(String dvdId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Dvd> returnAllDvds() {
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvdInfo(String dvdId) {
        return dvds.get(dvdId);
    }

    @Override
    public Dvd searchDvdByTitle(String movieTitle) {
        return dvds2.get(movieTitle);
    }


}
