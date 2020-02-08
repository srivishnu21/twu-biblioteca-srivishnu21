package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void displayListOfBooks() {
        for (Book book : bookList) {
            System.out.println(book.getBookName());
        }
    }
}
