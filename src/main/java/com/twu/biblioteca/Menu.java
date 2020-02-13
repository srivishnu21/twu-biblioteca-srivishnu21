package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    Printer printer = new Printer();
    Reader reader;
    private Library library;
    private Map<Integer, MenuItem> menuItemMap;

    public Menu(Library library, Reader reader) {
        this.library = library;
        this.reader = reader;
        menuItemMap = new HashMap<>();
        addMenuItem();
    }

    public void displayMenu() {
        printer.print("Menu options");
        printer.print("1. Display List of all books");
        printer.print("2. Check out a book");
        printer.print("3. Return a book");
        printer.print("4. Quit Application");
        printer.print("5. Display List of all movies");
        printer.print("6. Check out a movie");
        printer.print("Please Enter A Number");
    }

    public void execute() {
        while (reader.hasNext()) {
            displayMenu();
            int actionItem = reader.getInt();
            if (menuItemMap.containsKey(actionItem)) {
                MenuItem menuItem = menuItemMap.get(actionItem);
                menuItem.executeAction();
            } else
                printer.print("Invalid option.Please Enter correct option!");
            displayMenu();
        }

    }

    private void addMenuItem() {
        menuItemMap.put(1, new DisplayBookList(library));
        menuItemMap.put(5, new DisplayMovieList(library));
        menuItemMap.put(2, new CheckOutBook(reader, library));
        menuItemMap.put(3, new Return(reader, library));
        menuItemMap.put(4, new ExitApplication());
        menuItemMap.put(6, new CheckOutMovie(library, reader));
    }
}
