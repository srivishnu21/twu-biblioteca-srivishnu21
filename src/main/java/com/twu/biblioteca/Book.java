package com.twu.biblioteca;

public class Book {
    private String bookName;
    
    public Book(String bookName) {
        this.bookName = bookName;
    }

    public void printDetails() {
        System.out.println(bookName);
    }
}
