package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public abstract class Library {
    private List<LibraryItems> items;
    private List<LibraryItems> checkedOutItems;

    public Library(List<LibraryItems> items) {
        this.items = items;
        checkedOutItems = new ArrayList<>();
    }

    public boolean checkOutItem(LibraryItems libraryItem) {
        if (items.contains(libraryItem)) {
            checkedOutItems.add(libraryItem);
            items.remove(libraryItem);
            return true;
        }
        return false;
    }

    public boolean returnItem(LibraryItems libraryItem) {
        if (checkedOutItems.contains(libraryItem)) {
            checkedOutItems.remove(libraryItem);
            items.add(libraryItem);
            return true;
        }
        return false;
    }

    public void displayList() {
        if (items instanceof Book) {
            publish("Book Name\t\tYear Published\t\tAuthor Name");
        } else {
            publish("Movie Name\t\tYear released\t\tDirector\t\tRatings");
        }
        StringBuilder movieListBuilder = new StringBuilder();
        for (LibraryItems item : items) {
            movieListBuilder.append(item.toString()).append("\n");
        }
        publish(movieListBuilder.toString());
    }

    private void publish(String message) {
        Printer printer = new Printer();
        printer.print(message);
    }

}
