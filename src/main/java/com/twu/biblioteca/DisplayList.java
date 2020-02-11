package com.twu.biblioteca;

public class DisplayList extends MenuItem {

    Printer printer = new Printer();

    public DisplayList(Biblioteca biblioteca) {
        super(biblioteca);
    }

    @Override
    void execute() {
        biblioteca.displayBookList();
    }
}
