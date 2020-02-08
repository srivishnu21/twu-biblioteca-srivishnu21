package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        Printer printer=new Printer();
        printer.printAString(displayWelcomeMessage());
        Library library = new Library(new ArrayList<>());
        library.displayListOfBooks();

    }

    static String displayWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }
}
