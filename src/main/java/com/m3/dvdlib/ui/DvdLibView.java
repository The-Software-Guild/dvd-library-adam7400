package com.m3.dvdlib.ui;

import com.m3.dvdlib.dto.Dvd;

import java.util.List;

public class DvdLibView {
    private UserIO ui = new UserIOConsoleImpl();

    public int printMenuAndGetSelection(){
        ui.print("1. Add DVD");
        ui.print("2. Remove DVD");
        ui.print("3. Edit DVD info");
        ui.print("4. List DVDs");
        ui.print("5. Display DVD information");
        ui.print("6. Search DVD by movie title");
        ui.print("7. Load DVD library from a file");
        ui.print("8. Exit");

        return ui.readInt("Please choose from above: ",1, 8);
    }

    public Dvd getNewDvdInfo() {
        String dvdId = ui.readString("Please enter DVD ID");
        String movieTitle = ui.readString("Please enter movie title");
        String releaseDate = ui.readString("Please enter release date");
        String mPAArating = ui.readString("Please enter MPAA rating");
        String directorName  = ui.readString("Please enter director name");
        String studioName  = ui.readString("Please enter studio name ");
        String userNote = ui.readString("Add user note ");
        Dvd newDvd = new Dvd(movieTitle,releaseDate,mPAArating,directorName,studioName);
        newDvd.setDvdId(dvdId);
        newDvd.setUserNote(userNote);
        return newDvd;
    }

    public void displayAddDVDBanner() {
        ui.print("=== Add DVD ===");
    }

    public void displayAddSuccessBanner() {
        ui.readString("DVD successfully added. Please hit enter to continue");
    }

    public String getDvdIdChoice() {
        return ui.readString("Please enter the Dvd ID.");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("#%s : %s",
                    currentDvd.getDvdId(),
                    currentDvd.getTitle());
            ui.print(dvdInfo);
        }
        ui.readString("Please hit enter to continue.");
    }

    public void displayDvdInfo(Dvd currentDvd){
        if (currentDvd != null) {
            ui.print(currentDvd.getTitle());
            ui.print(currentDvd.getReleaseDate());
            ui.print(currentDvd.getmPAArating());
            ui.print(currentDvd.getDirectorName());
            ui.print(currentDvd.getStudioName());
            ui.print(currentDvd.getUserNote());
        }
        else {
            ui.print("No such DVD in the database.");
        }
        ui.readString("Please hit enter to continue");

    }
}
