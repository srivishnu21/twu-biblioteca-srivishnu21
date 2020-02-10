package com.twu.biblioteca;

public class ExitApplication extends MenuItem {
    private int actionNumber;

    public ExitApplication(int actionNumber, Biblioteca biblioteca) {
        super(4, biblioteca);
        this.actionNumber = actionNumber;
    }

    @Override
    int getActionNumber() {
        return actionNumber;
    }

    @Override
    void execute() {
        System.exit(0);
    }
}
