package com.twu.biblioteca;

public class ExitApplication extends MenuItem {

    public ExitApplication(Biblioteca biblioteca) {
        super( biblioteca);
    }


    @Override
    void execute() {
        System.exit(0);
    }
}
