package com.twu.biblioteca;

public class ExitApplication implements MenuItem {

    @Override
    public void executeAction() {
        System.exit(0);
    }
}
