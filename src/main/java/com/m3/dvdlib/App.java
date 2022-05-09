package com.m3.dvdlib;

import com.m3.dvdlib.controller.DvdLibController;
import com.m3.dvdlib.dao.DvdLibDao;
import com.m3.dvdlib.dao.DvdLibDaoImpl;
import com.m3.dvdlib.ui.DvdLibView;
import com.m3.dvdlib.ui.UserIO;
import com.m3.dvdlib.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO ui = new UserIOConsoleImpl();
        DvdLibView view = new DvdLibView(ui);
        DvdLibDao dao = new DvdLibDaoImpl();
        DvdLibController controller = new DvdLibController(view, dao);
        controller.run();
    }
}
