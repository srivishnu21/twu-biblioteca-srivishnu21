package com.twu.biblioteca;

public class DisplayList extends MenuItem {

    Printer printer = new Printer();
    private int actionNumber;

    public DisplayList(int actionNumber, Biblioteca biblioteca) {
        super(1, biblioteca);
        this.actionNumber = actionNumber;
    }

    @Override
    int getActionNumber() {
        return actionNumber;
    }

    @Override
    void execute() {
        biblioteca.displayBookList();
    }
}
