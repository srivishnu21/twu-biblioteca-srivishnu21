package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookKeeper {
    Printer printer = new Printer();
    private List<Book> bookList;
    private Map<Book, Boolean> bookCheckedOutList;

    public BookKeeper(List<Book> bookList) {
        this.bookList = bookList;
        bookCheckedOutList = new HashMap<>();
        for (Book book : this.bookList) {
            bookCheckedOutList.put(book, Boolean.FALSE);
        }
    }

    public void checkOutBook(String bookName) {
        Book book = getBook(bookName);
        if (book != null) {
            bookCheckedOutList.put(book, Boolean.TRUE);
            printer.print("Thank you! Enjoy the book");
        } else {
            printer.print("Sorry, that book is not available");
        }
    }

    public void returnBook(String bookName) {
        Book book = getBook(bookName);
        if (book != null) {
            bookCheckedOutList.put(book, Boolean.FALSE);
            printer.print("Thank you for returning the book");
        } else {
            printer.print("That is not a valid book to return.");
        }
    }

    private Book getBook(String bookName) {
        Book book = new Book(bookName);
        for (Book bookIterator : bookList) {
            if (bookIterator.equals(book)) {
                return bookIterator;
            }
        }
        return null;
    }

    void displayListOfBooksAvailable() {
        StringBuilder bookListBuilder = new StringBuilder();
        for (Book book : bookList) {
            if (!bookCheckedOutList.get(book))
                bookListBuilder.append(book.toString()).append("\n");
        }
        printer.print(bookListBuilder.toString());
    }

    public void displayListOfAllBooks() {
        printer.print("Book Name\t\tYear Published\t\tAuthor Name");
        StringBuilder bookListBuilder = new StringBuilder();
        for (Book book : bookList) {
            bookListBuilder.append(book.toString()).append("\n");
        }
        printer.print(bookListBuilder.toString());
    }
}
