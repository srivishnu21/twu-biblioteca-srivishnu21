package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BookKeeperTest {
    @Test
    void shouldCheckTheListOfAllBooksPrinted() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BookKeeper bookKeeper = new BookKeeper(bookList);
        bookKeeper.displayListOfAllBooks();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckOutABook() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BookKeeper bookKeeper = new BookKeeper(bookList);
        bookKeeper.checkOutBook("book1");

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckOutABookIfItContainsDisplaySuccessAMessage() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BookKeeper bookKeeper = new BookKeeper(bookList);
        bookKeeper.checkOutBook("book2");

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
        verify(mockedPrintStream, times(1)).println("Thank you! Enjoy the book");
    }

    @Test
    void shouldNotCheckOutABookIfItIsNotContainsDisplayUnSuccessAMessage() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BookKeeper bookKeeper = new BookKeeper(bookList);
        bookKeeper.checkOutBook("hffhtdt");

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
        verify(mockedPrintStream, times(1)).println("Sorry, that book is not available");
    }
}