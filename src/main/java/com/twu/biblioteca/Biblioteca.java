package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //Library in spanish - biblioteca

    private List<Book> books;
    private List<Book> checkedOutBooks;

    public Biblioteca(List<Book> books) {
        this.books = books;
        checkedOutBooks = new ArrayList<>();
    }

    public boolean checkOutBook(String bookName) {
        Book bookToFind = new Book(bookName, -1, "");
        if (books.contains(bookToFind)) {
            checkedOutBooks.add(bookToFind);
            books.remove(bookToFind);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        Book bookToReturn = new Book(bookName, -1, "");
        if (checkedOutBooks.contains(bookToReturn)) {
            books.add(bookToReturn);
            checkedOutBooks.remove(bookToReturn);
            return true;
        }
        return false;
    }

    public void displayBookList() {
        publish("Book Name\t\tYear Published\t\tAuthor Name");
        StringBuilder bookListBuilder = new StringBuilder();
        for (Book book : books) {
            bookListBuilder.append(book.toString()).append("\n");
        }
        publish(bookListBuilder.toString());
    }

    private void publish(String message) {
        Printer printer = new Printer();
        printer.print(message);
    }
}
