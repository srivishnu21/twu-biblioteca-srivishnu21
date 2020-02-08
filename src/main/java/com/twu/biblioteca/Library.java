package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void displayListOfBooks() {
        System.out.println("Book Name\t\tYear Published\t\tAuthor Name");
        for (Book book : bookList) {
            book.printDetails();
        }
    }
}
