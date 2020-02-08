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

    public String toString(){
        return bookName + "\t,\t" + yearPublished + "\t,\t" + authorName;
    }

}
