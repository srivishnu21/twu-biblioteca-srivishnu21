package com.twu.biblioteca;

public class Book {
    private String bookName;
    private int yearPublished;
    private String authorName;

    public Book(String bookName, int yearPublished, String authorName) {
        this.bookName = bookName;
        this.yearPublished = yearPublished;
        this.authorName = authorName;
    }

    public void printDetails() {
        System.out.println(bookName + " , " + yearPublished + " , " + authorName);
    }

}
