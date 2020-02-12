package com.twu.biblioteca;

public class DisplayItem implements MenuItem {

    private Biblioteca biblioteca;

    public DisplayItem(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
   public void executeAction() {
        biblioteca.displayBookList();
    }
}
