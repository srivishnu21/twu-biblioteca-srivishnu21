package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookKeeper {
    Printer printer = new Printer(); // TODO: why bookkeeper has a printer
    private List<Book> books;
    private Map<Book, Boolean> bookCheckedOutList; // TODO: checkedoutBooks

    public BookKeeper(List<Book> books) {
        this.books = books;
        bookCheckedOutList = new HashMap<>();
        for (Book book : this.books) {
            bookCheckedOutList.put(book, Boolean.FALSE);
        }
    }

    //TODO: doing two things
    public void checkOutBook(String bookName) {
        Book book = findBook(bookName);
        if (book != null) {
            bookCheckedOutList.put(book, Boolean.TRUE);
            printer.print("Thank you! Enjoy the book");
        } else {
            printer.print("Sorry, that book is not available");
        }
    }

    //TODO: doing two things
    public void returnBook(String bookName) {
        Book book = findBook(bookName);
        if (book != null) {
            bookCheckedOutList.put(book, Boolean.FALSE);
            printer.print("Thank you for returning the book");
        } else {
            printer.print("That is not a valid book to return.");
        }
    }

    private Book findBook(String bookName) {
        Book bookToFind = new Book(bookName);
        for (Book book : books) {
            if (book.equals(bookToFind)) {
                return book;
            }
        }
        return null;
    }

    void displayListOfBooksAvailable() {
        StringBuilder bookListBuilder = new StringBuilder();
        for (Book book : books) {
            if (!bookCheckedOutList.get(book))
                bookListBuilder.append(book.toString()).append("\n");
        }
        printer.print(bookListBuilder.toString());
    }

    public void displayListOfAllBooks() {
        printer.print("Book Name\t\tYear Published\t\tAuthor Name");
        StringBuilder bookListBuilder = new StringBuilder();
        for (Book book : books) {
            bookListBuilder.append(book.toString()).append("\n");
        }
        printer.print(bookListBuilder.toString());
    }
}
