package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    void shouldCheckIfDisplayWelcomeMessageFunctionReturnsCorrectString() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(expected, BibliotecaApp.displayWelcomeMessage());
    }

    @Test
    void shouldCheckTheListOfAllBooksPrinted() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BibliotecaApp.displayListOfBooks(bookList);

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc");
        verify(mockedPrintStream, times(1)).println("book2\t,\t2010\t,\txyz");

    }


    @Test
    void shouldCheckIfMenuListIsDisplayedAndListOfBooksIsDisplayed() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BibliotecaApp.displayMenu(1);

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
    }

    @Test
    void shouldCheckIfMenuListIsDisplayedAndIfInvalidNumberIsEnteredDisplayInvalidMessage() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BibliotecaApp.displayMenu(2);

        verify(mockedPrintStream, times(1)).println("Invalid option.Please Enter correct option!");
    }
}