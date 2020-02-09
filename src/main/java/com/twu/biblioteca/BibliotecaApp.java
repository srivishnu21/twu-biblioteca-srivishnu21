package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    static Printer printer = new Printer();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printer.print(displayWelcomeMessage());
        printer.print("Menu options");
        printer.print("1. Show List Of Books");
        printer.print("Please Enter A Number");
        int action = scanner.nextInt();
        displayMenu(action);

    }

    static void displayMenu(int action) {
        if (action == 1) {
            List<Book> bookList = getListOfBooks();
            displayListOfBooks(bookList);
        }
        else printer.print("Invalid option.Please Enter correct option!");
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
