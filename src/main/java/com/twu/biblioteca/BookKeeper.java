package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookKeeper {
    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";
    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";

    private List<Book> books;
    private Map<Book, Boolean> bookCheckedOutList; // TODO: checkedoutBooks

    public BookKeeper(List<Book> books) {
        this.books = books;
        bookCheckedOutList = new HashMap<>();
        for (Book book : this.books) {
            bookCheckedOutList.put(book, Boolean.FALSE);
        }
    }

    public void checkOutBook(String bookName) {
        Book book = findBook(bookName);
        if (book != null) {
            bookCheckedOutList.put(book, Boolean.TRUE);
            publishMessage(successCheckOutMessage);
        } else {
            publishMessage(unSuccessCheckOutMessage);
        }
    }

    public void returnBook(String bookName) {
        Book book = findBook(bookName);
        if (book != null) {
            bookCheckedOutList.put(book, Boolean.FALSE);
            publishMessage(successReturnMessage);
        } else {
            publishMessage(unSuccessReturnMessage);
        }
    }

    public void publishMessage(String message) {
        Printer printer = new Printer();
        printer.print(message);
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
        Printer printer = new Printer();
        StringBuilder bookListBuilder = new StringBuilder();
        for (Book book : books) {
            if (!bookCheckedOutList.get(book))
                bookListBuilder.append(book.toString()).append("\n");
        }
        printer.print(bookListBuilder.toString());
    }

    public void displayListOfAllBooks() {
        Printer printer = new Printer();
        printer.print("Book Name\t\tYear Published\t\tAuthor Name");
        StringBuilder bookListBuilder = new StringBuilder();
        for (Book book : books) {
            bookListBuilder.append(book.toString()).append("\n");
        }
        printer.print(bookListBuilder.toString());
    }
}
