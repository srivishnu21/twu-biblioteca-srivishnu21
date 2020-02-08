package com.twu.biblioteca;

public class Printer {

    public void printAString(String string) {
        System.out.println(string);
    }

    public void printBookDetails(Book book){
        System.out.println(book.toString());
    }
}
