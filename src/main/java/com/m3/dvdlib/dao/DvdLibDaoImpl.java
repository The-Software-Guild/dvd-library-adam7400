package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DvdLibDaoImpl implements DvdLibDao{

    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String dvdId, Dvd dvd) {
        return dvds.put(dvdId, dvd);
    }

    @Override
    public Dvd removeDvd(String dvdId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dvd editDvdInfo(String dvdId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Dvd> listAllDvds() {
        return new ArrayList<Dvd>(dvds.values());
    }


    @Override
    public Dvd displayDvdInfo(String dvdId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dvd searchDvdByTitle(String movieTitle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
