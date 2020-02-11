package com.twu.biblioteca;

public class DisplayList extends MenuItem {

    public DisplayList(Biblioteca biblioteca) {
        super(biblioteca);
    }

    @Override
    void execute() {
        biblioteca.displayBookList();
    }
}
