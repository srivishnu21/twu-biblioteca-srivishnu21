package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    Printer printer = new Printer();
    Scanner scanner = new Scanner(System.in);
    private Biblioteca biblioteca;

    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void displayMenu() {
        printer.print("Menu options");
        printer.print("1. Display List of all books");
        printer.print("2. Check out a book");
        printer.print("3. Return a book");
        printer.print("4. Quit Application");
        printer.print("Please Enter A Number");
    }

    public void execute() {
        displayMenu();
        while (scanner.hasNextInt()) {
            int actionItem = scanner.nextInt();
            switch (actionItem) {
                case 1:
                    biblioteca.displayListOfAllBooks();
                    break;
                case 2:
                    biblioteca.displayListOfAllBooks();
                    printer.print("Please Enter the name of the book want to checkout");
                    scanner.nextLine();
                    String bookToCheckOut = scanner.nextLine();
                    biblioteca.checkOutBook(bookToCheckOut);
                    break;
                case 3:
                    printer.print("Please Enter the name of the book want to return");
                    scanner.nextLine();
                    String bookToReturn = scanner.nextLine();
                    biblioteca.returnBook(bookToReturn);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    printer.print("Invalid option.Please Enter correct option!");
            }
            displayMenu();
        }

    }
}
