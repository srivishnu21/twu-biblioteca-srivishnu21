package com.twu.biblioteca;

public class DisplayList implements MenuItem {

    private Biblioteca biblioteca;

    public DisplayList(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
   public void executeAction() {
        biblioteca.displayBookList();
    }
}
