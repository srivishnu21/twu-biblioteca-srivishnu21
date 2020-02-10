package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

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
        verify(mockedPrintStream, times(1)).println("4. Quit Application");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndListOfBooksIsDisplayed() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu = new Menu(new BookKeeper(new ArrayList<>()));

        menu.doAction(1);

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndIfInvalidNumberIsEnteredDisplayInvalidMessage() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu = new Menu(new BookKeeper(new ArrayList<>()));

        menu.doAction(22);

        verify(mockedPrintStream, times(1)).println("Invalid option.Please Enter correct option!");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndCheckOutABook() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        BookKeeper bookKeeper = new BookKeeper(bookList);
        Menu menu = new Menu(bookKeeper);

        menu.doAction(2);

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndReturn() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        BookKeeper bookKeeper = new BookKeeper(bookList);
        Menu menu = new Menu(bookKeeper);

        menu.doAction(3);

        verify(mockedPrintStream, times(1)).println("Please Enter the name of the book want to return");
    }

}