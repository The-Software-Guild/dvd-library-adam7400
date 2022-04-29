package com.m3.dvdlib.dao;

import com.m3.dvdlib.dto.Dvd;

import java.util.List;

public interface DvdLibDao {

    Dvd addDvd(String dvdId, Dvd dvd);

    Dvd removeDvd(String dvdId);

    Dvd editDvdInfo(String dvdId);

    List<Dvd> listAllDvds();

    Dvd displayDvdInfo(String dvdId);

    Dvd searchDvdByTitle(String movieTitle);

    // some file import method?


}
