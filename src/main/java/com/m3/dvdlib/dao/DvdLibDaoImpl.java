package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;
import org.apache.commons.collections4.list.TreeList;

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




}


