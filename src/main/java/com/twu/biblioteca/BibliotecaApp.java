package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    public static List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("harry potter", 2003, "j.k rowling"),
            new Book("Two states", 2005, "chetan bghath"),
            new Book("Wings of fire", 2005, "apj")));
    static Printer printer = new Printer();
    static BookKeeper bookKeeper = new BookKeeper(bookList);
    static Menu menu = new Menu(bookKeeper);

    public static void main(String[] args) {
        printer.print(displayWelcomeMessage());
        menu.displayMenu();

    }

    static String displayWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

}
