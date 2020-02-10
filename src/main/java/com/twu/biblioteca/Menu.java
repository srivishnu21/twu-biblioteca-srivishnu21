package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";
    Printer printer = new Printer();
    Reader reader;
    private Biblioteca biblioteca;
    private List<MenuItem> menuItemList;

    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        menuItemList = new ArrayList<>();
        addMenuItem();
    }

    public Menu(Biblioteca biblioteca, Reader reader) {

        this.biblioteca = biblioteca;
        this.reader = reader;
        menuItemList = new ArrayList<MenuItem>();
        addMenuItem();
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
        int actionItem = reader.getInt();
        System.out.println(actionItem);
        for (MenuItem menuItem : menuItemList) {
            if (actionItem == menuItem.getActionNumber()) {
                menuItem.execute();
            }
        }

    }

    private void addMenuItem() {
        menuItemList.add(new DisplayList(1, biblioteca));
        menuItemList.add(new checkOut(2, biblioteca,reader));
    }
}
