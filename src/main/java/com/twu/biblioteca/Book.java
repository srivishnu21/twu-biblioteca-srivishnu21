package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private String bookName;
    private int yearPublished;
    private String authorName;

    public Book(String bookName, int yearPublished, String authorName) {
        this.bookName = bookName;
        this.yearPublished = yearPublished;
        this.authorName = authorName;
    }

    //TODO: two constructors?
    public Book(String bookName) {
        this.bookName = bookName;
    }

    //TODO: Missing unit tests for books
    public String toString(){
        return bookName + "\t,\t" + yearPublished + "\t,\t" + authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookName.equals(book.bookName);
    }


    //TODO: missing hashCode implementation
}
