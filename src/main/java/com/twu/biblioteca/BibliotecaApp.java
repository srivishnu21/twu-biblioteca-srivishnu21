package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    static String welcomeMessage="Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("harry potter", 2003, "j.k rowling"),
            new Book("Two states", 2005, "chetan bghath"),
            new Book("Wings of fire", 2005, "apj")));
    static Printer printer = new Printer();
    //TODO: better name for BookKeeper
    static BookKeeper bookKeeper = new BookKeeper(bookList);
    static Menu menu = new Menu(bookKeeper);

    public static void main(String[] args) {
        //TODO: extract as function and test
        printer.print(welcomeMessage);
        //TODO: better name for doAction
        menu.doAction();
    }



    //TODO: do you need a function for a message
    static String displayWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

}
