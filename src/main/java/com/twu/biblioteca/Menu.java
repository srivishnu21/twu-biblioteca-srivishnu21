package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    Printer printer = new Printer();
    Scanner scanner = new Scanner(System.in);
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
        printer.print("Please Enter A Number");
    }

    public void doAction() {
        displayMenu();
        while (scanner.hasNextInt()) {
            //TODO: Get rid of if else ladder
            int actionItem = scanner.nextInt();
            if (actionItem == 1) {
                bookKeeper.displayListOfAllBooks();
            } else if (actionItem == 2) {
                bookKeeper.displayListOfBooksAvailable();
                printer.print("Please Enter the name of the book want to checkout");
                scanner.nextLine();
                String bookName = scanner.nextLine();
                bookKeeper.checkOutBook(bookName);
            } else if (actionItem == 3) {
                printer.print("Please Enter the name of the book want to return");
                scanner.nextLine();
                String bookName = scanner.nextLine();
                bookKeeper.returnBook(bookName);
            } else if (actionItem == 4) {
                System.exit(0);
            } else printer.print("Invalid option.Please Enter correct option!");
            displayMenu();
        }
    }

}
