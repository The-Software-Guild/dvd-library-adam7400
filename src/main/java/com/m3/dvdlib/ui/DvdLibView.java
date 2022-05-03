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
        // ui.print("7. Load DVD library from a file");
        ui.print("8. Exit");

        return ui.readInt("Please choose from above: ",1, 8);
    }

    public String getDvdTitleChoice(){
        return ui.readString("Please enter the DVD title");
    }

    public Dvd getNewDvdInfo() {
        String movieTitle = ui.readString("Please enter movie title");
        String releaseDate = ui.readString("Please enter release date");
        String mPAArating = ui.readString("Please enter MPAA rating");
        String directorName  = ui.readString("Please enter director name");
        String studioName  = ui.readString("Please enter studio name ");
        String userNote = ui.readString("Add user note ");
        Dvd newDvd = new Dvd(movieTitle,releaseDate,mPAArating,directorName,studioName);
        newDvd.setUserNote(userNote);
        return newDvd;
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("%s",
                    currentDvd.getTitle());
            ui.print(dvdInfo);
        }
        ui.readString("Please hit enter to continue.");
    }

    public void showDvdInfo(Dvd currentDvd){
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

    public int editDvdInfoMenu(Dvd currentDvd){
        ui.print("*** EDIT DVD INFO");
        ui.print("1. Title");
        ui.print("2. Release date");
        ui.print("3. MPAA rating");
        ui.print("4. Director");
        ui.print("5. Studio name");
        ui.print("6. User note");
        return ui.readInt("Please choose from above: ",1, 8);
    }



    public void addDvdBanner(){
        ui.print("*** ADDING DVD ***");
    }

    public void addDvdMessage(){
        ui.print("*****");
        ui.print("The DVD has been successfully added to the database");
        ui.print("*****");
    }

    public void removeDvdBanner(){
        ui.print("*** REMOVING DVD ***");
    }

    public void removeDvdMessage(){
        ui.print("*****");
        ui.print("The DVD has been successfully removed from the database");
        ui.print("*****");
    }

    public void listDvdsBanner(){
        ui.print("*** DVD LIST ***");
    }

    public void dvdInfoBanner(){
        ui.print("*** DVD INFO ***");
    }
}
