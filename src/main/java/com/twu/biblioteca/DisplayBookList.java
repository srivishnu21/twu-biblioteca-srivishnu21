package com.twu.biblioteca;

public class DisplayBookList implements MenuItem {

    private Library library;

    public DisplayBookList(Library library) {
        this.library = library;
    }

    @Override
   public void executeAction() {
        library.displayList();
    }
}
