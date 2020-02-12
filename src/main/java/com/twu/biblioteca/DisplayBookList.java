package com.twu.biblioteca;

public class DisplayBookList implements MenuItem {

    private Biblioteca biblioteca;

    public DisplayBookList(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
   public void executeAction() {
        biblioteca.displayBookList();
    }
}
