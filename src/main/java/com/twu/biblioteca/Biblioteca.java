package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";
    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";

    private List<Book> books;
    private List<Book> checkedOutBooks;

    public Biblioteca(List<Book> books) {
        this.books = books;
        checkedOutBooks = new ArrayList<>();
    }

    public void checkOutBook(String bookName) {
        Book bookToFind = new Book(bookName, -1, "");
        if (books.contains(bookToFind)) {
            checkedOutBooks.add(bookToFind);
            books.remove(bookToFind);
            publishMessage(successCheckOutMessage);
        } else {
            publishMessage(unSuccessCheckOutMessage);
        }
    }

    public void returnBook(String bookName) {
        Book bookToReturn = new Book(bookName, -1, "");
        if (checkedOutBooks.contains(bookToReturn)) {
            books.add(bookToReturn);
            checkedOutBooks.remove(bookToReturn);
            publishMessage(successReturnMessage);
        } else {
            publishMessage(unSuccessReturnMessage);
        }
    }

    public void publishMessage(String message) {
        Printer printer = new Printer();
        printer.print(message);
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
