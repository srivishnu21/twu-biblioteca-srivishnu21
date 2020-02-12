package com.twu.biblioteca;

public class DisplayMovieList implements MenuItem {
    private Biblioteca biblioteca;

    public DisplayMovieList(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void executeAction() {
        biblioteca.displayMovieList();
    }
}
