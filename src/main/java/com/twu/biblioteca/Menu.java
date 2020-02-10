package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    Printer printer = new Printer();
    Reader reader;
    private Biblioteca biblioteca;
    private List<MenuItem> menuItemList;

    public Menu(Biblioteca biblioteca, Reader reader) {

        this.biblioteca = biblioteca;
        this.reader = reader;
        menuItemList = new ArrayList<>();
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
        while (reader.hasNext()) {
            displayMenu();
            boolean flag = false;
            int actionItem = reader.getInt();
            for (MenuItem menuItem : menuItemList) {
                if (actionItem == menuItem.getActionNumber()) {
                    menuItem.execute();
                    flag = true;
                }
            }
            if (!flag) {
                printer.print("Invalid option.Please Enter correct option!");
            }
            displayMenu();
        }

    }

    private void addMenuItem() {
        menuItemList.add(new DisplayList(1, biblioteca));
        menuItemList.add(new checkOut(2, biblioteca, reader));
        menuItemList.add(new Return(3, biblioteca, reader));
        menuItemList.add(new ExitApplication(4, biblioteca));
    }
}
