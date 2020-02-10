package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Printer printer = new Printer();
    private BookKeeper bookKeeper;

    public Menu(BookKeeper bookKeeper) {
        this.bookKeeper = bookKeeper;
    }

    public void displayMenu() {
        printer.print("Menu options");
        printer.print("1. Display List of all books");
        printer.print("2. Check out a book");
        printer.print("3. Return a book");
        printer.print("4. Quit Application");
    }

    public void doAction(int actionItem) {
        displayMenu();
        printer.print("Please Enter A Number");
        if (actionItem == 1) {
            printer.print("Book Name\t\tYear Published\t\tAuthor Name");
            bookKeeper.displayListOfAllBooks();
        }
        if (actionItem == 2) {
            bookKeeper.displayListOfBooksAvailable();
            printer.print("Please Enter the name of the book want to checkout");
            String bookName = "";
            bookKeeper.checkOutBook(bookName);
        }
        if (actionItem == 3) {
            printer.print("Please Enter the name of the book want to return");
            String bookName = "";
            bookKeeper.returnBook(bookName);
        }
        if (actionItem == 4) {
            System.exit(0);
        } else printer.print("Invalid option.Please Enter correct option!");
    }

}
