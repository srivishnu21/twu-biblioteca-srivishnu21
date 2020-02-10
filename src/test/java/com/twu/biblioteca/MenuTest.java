package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldCheckIfDisplayMenuMethodDisplayEveryMenu() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu = new Menu(new BookKeeper(new ArrayList<>()));

        menu.displayMenu();

        verify(mockedPrintStream, times(1)).println("Menu options");
        verify(mockedPrintStream, times(1)).println("1. Display List of all books");
        verify(mockedPrintStream, times(1)).println("2. Check out a book");
        verify(mockedPrintStream, times(1)).println("3. Return a book");
        verify(mockedPrintStream, times(1)).println("Please Enter A Number");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndListOfBooksIsDisplayed() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Menu menu = new Menu(new BookKeeper(new ArrayList<>()));

        menu.execute();

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndIfInvalidNumberIsEnteredDisplayInvalidMessage() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("22".getBytes());
        System.setIn(in);
        Menu menu = new Menu(new BookKeeper(new ArrayList<>()));

        menu.execute();

        verify(mockedPrintStream, times(1)).println("Invalid option.Please Enter correct option!");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndCheckOutABook() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("2\nbook1".getBytes());
        System.setIn(in);
        BookKeeper bookKeeper = new BookKeeper(bookList);
        Menu menu = new Menu(bookKeeper);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
        verify(mockedPrintStream, times(1)).println("Thank you! Enjoy the book");
    }

    @Test
    void shouldNotCheckOutABookIfItIsInvalid() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("2\njhdx".getBytes());
        System.setIn(in);
        BookKeeper bookKeeper = new BookKeeper(bookList);
        Menu menu = new Menu(bookKeeper);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
        verify(mockedPrintStream, times(1)).println("Sorry, that book is not available");
    }

    @Test
    void shouldReturnABookIfItIsValid() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("2\nbook1\n3\nbook1".getBytes());
        System.setIn(in);
        BookKeeper bookKeeper = new BookKeeper(bookList);
        Menu menu = new Menu(bookKeeper);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
        verify(mockedPrintStream, times(1)).println("Thank you! Enjoy the book");
        verify(mockedPrintStream, times(1)).println("Please Enter the name of the book want to return");
        verify(mockedPrintStream, times(1)).println("Thank you for returning the book");
    }

    @Test
    void shouldNotReturnABookIfItIsNotValid() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("3\nbocbk".getBytes());
        System.setIn(in);
        BookKeeper bookKeeper = new BookKeeper(bookList);
        Menu menu = new Menu(bookKeeper);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("Please Enter the name of the book want to return");
        verify(mockedPrintStream, times(1)).println("That is not a valid book to return.");
    }

}