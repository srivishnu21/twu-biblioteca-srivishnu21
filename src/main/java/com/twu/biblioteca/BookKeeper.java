package com.twu.biblioteca;

import java.util.List;

public class BookKeeper {
    Printer printer = new Printer();
    private List<Book> bookList;

    public BookKeeper(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void displayListOfBooks() {
        for (Book book : bookList) {
            printer.printBookDetails(book);
        }
    }
}
