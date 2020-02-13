package com.twu.biblioteca;

public class DisplayMovieList implements MenuItem {
    private Library library;

    public DisplayMovieList(Library library) {
        this.library = library;
    }

    @Override
    public void executeAction() {
        library.displayList();
    }
}
