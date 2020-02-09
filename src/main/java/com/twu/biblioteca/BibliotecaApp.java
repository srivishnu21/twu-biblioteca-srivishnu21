package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    static Printer printer = new Printer();

    public static void main(String[] args) {
        printer.print(displayWelcomeMessage());
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public static void displayListOfBooks(List<Book> bookList) {
        printer.print("Book Name\t\tYear Published\t\tAuthor Name");
        for (Book book : bookList) {
            printer.printBookDetails(book);
        }
    }

    static String displayWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static List<Book> getListOfBooks() {
        return new ArrayList<>();
    }
}
