package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";
    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";
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
                    biblioteca.displayBookList();
                    break;
                case 2:
                    biblioteca.displayBookList();
                    printer.print("Please Enter the name of the book want to checkout");
                    scanner.nextLine();
                    String bookToCheckOut = scanner.nextLine();
                    if (biblioteca.checkOutBook(bookToCheckOut)) {
                        printer.print(successCheckOutMessage);
                        break;
                    }
                    printer.print(unSuccessCheckOutMessage);
                    break;
                case 3:
                    printer.print("Please Enter the name of the book want to return");
                    scanner.nextLine();
                    String bookToReturn = scanner.nextLine();
                    if (biblioteca.returnBook(bookToReturn)) {
                        printer.print(successReturnMessage);
                        break;
                    }
                    printer.print(unSuccessReturnMessage);
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
