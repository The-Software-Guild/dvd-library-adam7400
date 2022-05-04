package com.m3.dvdlib.controller;

import com.m3.dvdlib.dao.DvdLibDao;
import com.m3.dvdlib.dao.DvdLibDaoImpl;
import com.m3.dvdlib.dto.Dvd;
import com.m3.dvdlib.ui.DvdLibView;
import com.m3.dvdlib.ui.UserIO;
import com.m3.dvdlib.ui.UserIOConsoleImpl;

import java.util.List;
import java.util.Scanner;

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
                    addDvd();
                    break;
                case 2:
                    removeDvd();
                    break;
                case 3:
                    printDvdInfo();
                    break;
                case 4:
                    editDvdInfo();
                    break;
                case 5:
                    listAllDvds();
                    break;
                case 6:
                    readFromFile();
                    break;
                case 7:
                    keepGoing = false;
                    break;

            }

        }
        view.goodbyeMessage();
    }

    private void addDvd() {
        view.addDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        Dvd oldDvd = dao.accessDvdInfo(newDvd.getMovieTitle());
        Boolean isInDb = newDvd.equals(oldDvd);
        if (!isInDb) dao.addDvd(newDvd);
        view.addDvdMessage(isInDb);
    }

    private void removeDvd() {
        view.removeDvdBanner();
        String dvdTitleChoice = view.getDvdTitleChoice();
        Dvd oldDvd = dao.accessDvdInfo(dvdTitleChoice);
        Boolean isInDb = isInDbCheck(oldDvd);
        if (isInDb) dao.removeDvd(dvdTitleChoice);
        view.removeDvdMessage(isInDb);
    }

    private void editDvdInfo() {
        Boolean keepGoing = true;
        String dvdTitleChoice = view.getDvdTitleChoice();
        Dvd oldDvd = dao.accessDvdInfo(dvdTitleChoice);
        Boolean isInDb = isInDbCheck(oldDvd);
        if (isInDb) {
            while (keepGoing) {
                int selection = view.printEditDvdInfoMenu();
                switch (selection) {
                    case 1:
                        dao.removeDvd(dvdTitleChoice);
                        String newEntry = view.getNewEntry();
                        oldDvd.setMovieTitle(newEntry);
                        dao.addDvd(oldDvd);     // movie title is key
                        view.editSuccessMessage();
                        break;
                    case 2:
                        oldDvd.setReleaseDate(view.getNewEntry());
                        view.editSuccessMessage();
                        break;
                    case 3:
                        oldDvd.setmPAArating(view.getNewEntry());
                        view.editSuccessMessage();
                        break;
                    case 4:
                        oldDvd.setDirectorName(view.getNewEntry());
                        view.editSuccessMessage();
                        break;
                    case 5:
                        oldDvd.setStudioName(view.getNewEntry());
                        view.editSuccessMessage();
                        break;
                    case 6:
                        oldDvd.setUserNote(view.getNewEntry());
                        view.editSuccessMessage();
                        break;
                    case 7:
                        keepGoing = false;
                        view.leaveEditMessage();
                        break;
                }
            }
        } else {
            view.notInDbMessage();
        }
    }


    private void listAllDvds() {
        view.listDvdsBanner();
        List<Dvd> dvdList = dao.listAllDvdTitles();
        view.displayDvdList(dvdList);
    }

    private void printDvdInfo() {
        view.dvdInfoBanner();
        String dvdTitleChoice = view.getDvdTitleChoice();
        Dvd currentDvd = dao.accessDvdInfo(dvdTitleChoice);
        Boolean isInDb = isInDbCheck(currentDvd);
        view.showDvdInfo(currentDvd, isInDb);
    }

    private void readFromFile(){
        Scanner scanner = ui.readFile("movieDb.txt"); // some of these lines might belong elsewhere
        while (scanner.hasNextLine()) {
            String movieTitle = scanner.nextLine();
            String releaseDate = scanner.nextLine();
            String mPAArating = scanner.nextLine();
            String directorName = scanner.nextLine();
            String studioName = scanner.nextLine();
            Dvd newDvd = new Dvd(movieTitle, releaseDate, mPAArating, directorName, studioName);
            dao.addDvd(newDvd);
        }
        view.libraryLoadedMessage();
    }

    private Boolean isInDbCheck(Dvd oldDvd) { // should this one belong to dao?
        return oldDvd != null;
    }

}






