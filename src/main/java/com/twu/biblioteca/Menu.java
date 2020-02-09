package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
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

    public int getActionNumber() {
        return scanner.nextInt();
    }

    private Map<Integer, String> getMenuMap() {
        Map<Integer, String> menuMap = new HashMap<>();
        menuMap.put(1, "Display List of all books");
        return menuMap;
    }
}
