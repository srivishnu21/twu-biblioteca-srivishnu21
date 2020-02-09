package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldCheckIfDisplayMenuMethodDisplayEveryMenu() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu=new Menu(new BookKeeper(new ArrayList<>()));

        menu.displayMenu();

        verify(mockedPrintStream,times(1)).println("Menu options");
        verify(mockedPrintStream,times(1)).println("1.  Display List of all books");
        verify(mockedPrintStream,times(1)).println("2.  Check out a book");
        verify(mockedPrintStream,times(1)).println("Please Enter A Number");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndListOfBooksIsDisplayed() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu=new Menu(new BookKeeper(new ArrayList<>()));

        menu.doAction(1);

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndIfInvalidNumberIsEnteredDisplayInvalidMessage() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu=new Menu(new BookKeeper(new ArrayList<>()));

        menu.doAction(22);

        verify(mockedPrintStream, times(1)).println("Invalid option.Please Enter correct option!");
    }

}