package com.m3.dvdlib.ui;

import com.m3.dvdlib.dto.Dvd;

import java.util.List;
import java.util.Scanner;

public class DvdLibView {
    private UserIO ui = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        ui.print("\n");
        printStars();
        ui.print("DVD LIBRARY");
        printStars();
        ui.print("1. Add DVD");
        ui.print("2. Remove DVD");
        ui.print("3. Display DVD information");
        ui.print("4. Edit DVD information");
        ui.print("5. List DVDs");
        ui.print("6. Load DVD library from a file");
        ui.print("7. Exit");

        return ui.readInt("Please choose from the menu: ", 1, 7);
    }

    public void goodbyeMessage(){
        ui.print("\n*** GOODBYE ***");
    }

    public Dvd getNewDvdInfo() {
        String movieTitle = ui.readString("Please enter movie title:");
        String releaseDate = ui.readString("Please enter release date:");
        String mPAArating = ui.readString("Please enter MPAA rating:");
        String directorName = ui.readString("Please enter director name:");
        String studioName = ui.readString("Please enter studio name:");
        String userNote = ui.readString("Add user note:");
        Dvd newDvd = new Dvd(movieTitle, releaseDate, mPAArating, directorName, studioName);
        newDvd.setUserNote(userNote);
        return newDvd;
    }

    public String getDvdTitleChoice() {
        return ui.readString("Please enter the DVD title");
    }

    public void showDvdInfo(Dvd currentDvd, Boolean isInDb) {
        if (isInDb) {
            ui.print(currentDvd.toString());
            hitEnterMessage();
        } else {
            notInDbMessage();
        }
    }
    public int printEditDvdInfoMenu() {
        ui.print("*** EDITING MODE ***");
        ui.print("1. Title");
        ui.print("2. Release date");
        ui.print("3. MPAA rating");
        ui.print("4. Director");
        ui.print("5. Studio name");
        ui.print("6. User note");
        ui.print("7. Exit editing mode");
        return ui.readInt("Please choose from above: ", 1, 7);
    }

    public String getNewEntry() {
        return ui.readString("Please type in the new entry: ");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        if(!dvdList.isEmpty()) {
            for (Dvd currentDvd : dvdList) {
                ui.print(currentDvd.getMovieTitle());
            }
        }
        else{
            ui.print("Library is empty");
        }
        hitEnterMessage();
    }

    public String typeInFilePath(){
        return ui.readString("Please type in file path: ");
    }


    // BANNERS AND MESSAGES
    public void addDvdBanner() {
        ui.print("\n*** ADDING DVD ***");
    }

    public void removeDvdBanner() {
        ui.print("\n*** REMOVING DVD ***");
    }

    public void listDvdsBanner() {
        ui.print("\n*** DVD LIST ***");
    }

    public void dvdInfoBanner() {
        ui.print("\n*** DVD INFO ***");
    }

    public void addDvdMessage(Boolean isInDb) {

        if (!isInDb) {
            ui.print("\n*** DVD WAS ADDED ***");
        }
        else {
            ui.print("\n*** ALREADY UP ***");
        }
        hitEnterMessage();

    }

    public void removeDvdMessage(Boolean isInDb) {
        if (isInDb) {
            ui.print("\n*** DVD REMOVED ***");
            hitEnterMessage();
        }
        else {
            notInDbMessage();
        }

    }

    public void leaveEditMessage(){
        ui.print("\n*** LEAVING EDIT MODE ***");
        hitEnterMessage();
    }

    public void editSuccessMessage(){
        ui.print("\n*** EDIT SUCCESS ***");
        hitEnterMessage();
    }

    public void libraryLoadedMessage(){
        ui.print("\n*** LIBRARY LOADED ***");
        hitEnterMessage();
    }

    public void fileSavedMessage(String filePath){
        ui.print("\nThe library has been saved to " + filePath);
    }

    public void notInDbMessage(){
        ui.print("\n*** NOT IN DATABASE ***");
        hitEnterMessage();
    }

    private void hitEnterMessage(){
        ui.readString("\nHit ENTER to proceed");

    }

    private void printStars(){
        ui.print("********************");
    }



}
