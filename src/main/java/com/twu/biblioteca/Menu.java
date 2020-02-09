package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<Integer, String> menuMap = getMenuMap();
    Printer printer = new Printer();
    private BookKeeper bookKeeper;

    public Menu(BookKeeper bookKeeper) {
        this.bookKeeper = bookKeeper;
    }

    public void displayMenu() {
        printer.print("Menu options");
        for (Integer integer : menuMap.keySet()) {
            printer.printMenu(integer, menuMap.get(integer));
        }
        printer.print("Please Enter A Number");
    }

    public void doAction(int actionItem) {
        if (actionItem == 1) {
            printer.print("Book Name\t\tYear Published\t\tAuthor Name");
            bookKeeper.displayListOfAllBooks();
        } else printer.print("Invalid option.Please Enter correct option!");
    }

    private Map<Integer, String> getMenuMap() {
        Map<Integer, String> menuMap = new HashMap<>();
        menuMap.put(1, "Display List of all books");
        menuMap.put(2, "Check out a book");
        return menuMap;
    }
}
