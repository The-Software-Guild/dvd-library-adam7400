package com.m3.dvdlib.controller;

import com.m3.dvdlib.dao.DvdLibDao;
import com.m3.dvdlib.dao.DvdLibDaoImpl;
import com.m3.dvdlib.dto.Dvd;
import com.m3.dvdlib.ui.DvdLibView;
import com.m3.dvdlib.ui.UserIO;
import com.m3.dvdlib.ui.UserIOConsoleImpl;

import java.util.List;

public class DvdLibController {
    private UserIO ui = new UserIOConsoleImpl();
    private DvdLibView view = new DvdLibView();
    private DvdLibDao dao = new DvdLibDaoImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    createDvd();
                    break;
                case 2:
                    removeDvd();
                case 3:
                    editDvdInfo();
                    break;
                case 4:
                    listAllDvds();
                    break;
                case 5:
                    printDvdInfo();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    keepGoing = false;
                    break;

            }

        }
    }

    private void createDvd() {
        view.addDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();      // user input
        dao.addDvd(newDvd);  // storage in the map
        view.addDvdMessage();
    }

    private void removeDvd() {
        view.removeDvdBanner();
        String dvdTitleChoice = view.getDvdTitleChoice();
        dao.removeDvd(dvdTitleChoice);
        view.removeDvdMessage();
    }

    private void editDvdInfo() {
        boolean keepGoing = true;
        String movieTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.accessDvdInfo(movieTitle);

        while (keepGoing) {
            int selection = view.printEditDvdInfoMenu();
            String newEntry = view.getNewEntry();
            switch (selection) {
                case 1:
                    dvd.setMovieTitle(newEntry);
                    break;
                case 2:
                    dvd.setReleaseDate(newEntry);
                    break;
                case 3:
                    dvd.setmPAArating(newEntry);
                    break;
                case 4:
                    dvd.setDirectorName(newEntry);
                    break;
                case 5:
                    dvd.setStudioName(newEntry);
                    break;
                case 6:
                    dvd.setUserNote(newEntry);
                    break;
                case 7:
                    keepGoing = false;
                    break;
            }
        }

    }

    private void listAllDvds() {
        view.listDvdsBanner();
        List<Dvd> dvdList = dao.listAllDvdTitles();
        view.displayDvdList(dvdList);
    }

    private void printDvdInfo() {
        view.dvdInfoBanner();
        String movieTitle = view.getDvdTitleChoice();
        Dvd currentDvd = dao.accessDvdInfo(movieTitle);
        view.showDvdInfo(currentDvd);
    }

}






