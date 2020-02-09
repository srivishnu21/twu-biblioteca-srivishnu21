package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<Integer, String> menuMap = getMenuMap();
    Printer printer = new Printer();
    int actionItem = getActionNumber();

    public void displayMenu() {
        printer.print("Menu options");
        for (Integer integer : menuMap.keySet()) {
            printer.printMenu(integer, menuMap.get(integer));
        }
        printer.print("Please Enter A Number");
    }

    public void doAction(int actionItem) {
        if (actionItem == 1) {
            BibliotecaApp.displayListOfBooks(new ArrayList<>());
        } else printer.print("Invalid option.Please Enter correct option!");
    }

    public int getActionNumber() {
        return 1;
    }

    private Map<Integer, String> getMenuMap() {
        Map<Integer, String> menuMap = new HashMap<>();
        menuMap.put(1, "Display List of all books");
        return menuMap;
    }
}
