package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookKeeper {
    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";
    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";

    private List<Book> books;
    private List<Book> checkedOutBooks;

    public BookKeeper(List<Book> books) {
        this.books = books;
        checkedOutBooks = new ArrayList<>();
    }

    public void checkOutBook(String bookName) {
        Book book = findBookInBookInList(bookName);
        if (book != null) {
            checkedOutBooks.add(book);
            books.remove(book);
            publishMessage(successCheckOutMessage);
        } else {
            publishMessage(unSuccessCheckOutMessage);
        }
    }

    public void returnBook(String bookName) {
        Book book = findBookInCheckedOutList(bookName);
        if (book != null) {
            books.add(book);
            checkedOutBooks.remove(book);
            publishMessage(successReturnMessage);
        } else {
            publishMessage(unSuccessReturnMessage);
        }
    }

    public void publishMessage(String message) {
        Printer printer = new Printer();
        printer.print(message);
    }

    private Book findBookInBookInList(String bookName) {
        Book bookToFind = new Book(bookName);
        for (Book book : books) {
            if (book.equals(bookToFind)) {
                return book;
            }
        }
        return null;
    }

    private Book findBookInCheckedOutList(String bookName) {
        Book bookToFind = new Book(bookName);
        for (Book book : checkedOutBooks) {
            if (book.equals(bookToFind)) {
                return book;
            }
        }
        return null;
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
