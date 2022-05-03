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

    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;

        while(keepGoing){
            menuSelection = view.printMenuAndGetSelection();

            switch(menuSelection){
                case 1:
                    createDvd();
                    break;
                case 2:
                    removeDvd();
                case 3:
                    break;
                case 4:
                    listAllDvds();
                    break;
                case 5:
                    showDvdInfo();

            }

        }
    }


    private void createDvd() {
        view.displayAddDVDBanner();
        Dvd newDvd = view.getNewDvdInfo();      // user input
        dao.addDvd(newDvd.getDvdId(), newDvd);  // storage in the map
        view.displayAddSuccessBanner();
    }

    private void removeDvd() {
        String dvdId = view.getDvdIdChoice();
        dao.removeDvd(dvdId);
    }

    private void listAllDvds(){
        List<Dvd> dvdList = dao.returnAllDvds();
        view.displayDvdList(dvdList);
    }

    private void showDvdInfo(){
        String idChoice = view.getDvdIdChoice();
        Dvd currentDvd = dao.getDvdInfo(idChoice);
        view.displayDvdInfo(currentDvd);
    }


}

