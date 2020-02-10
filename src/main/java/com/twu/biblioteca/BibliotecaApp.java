package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    public static List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("harry potter",
                    2003, "J.k rowling"),
            new Book("Two states", 2005, "chetan bhagat"),
            new Book("Wings of fire", 2005, "apj")));
    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    static Printer printer = new Printer();
    static Biblioteca biblioteca = new Biblioteca(bookList);
    static Menu menu = new Menu(biblioteca);

    public static void main(String[] args) {
        printer.print(welcomeMessage);
        menu.execute();
    }
}
