package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    void shouldCheckIfDisplayWelcomeMessageIsPrintedOrNot() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Menu(new Biblioteca(new ArrayList<>())));

        bibliotecaApp.main(null);

        verify(mockedPrintStream, times(1)).println("Welcome to Biblioteca. " +
                "Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    void shouldCheckIfMenuExecuteMethodIsCalled() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("harry potter",
                        2003, "J.k rowling"),
                new Book("Two states", 2005, "chetan bhagat"),
                new Book("Wings of fire", 2005, "apj")));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Biblioteca biblioteca = new Biblioteca(bookList);
        Menu menu = new Menu(biblioteca);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu);

        bibliotecaApp.main(null);

        verify(mockedPrintStream, times(2)).println("Menu options");
        verify(mockedPrintStream, times(2)).println("1. Display List of all books");
        verify(mockedPrintStream, times(2)).println("2. Check out a book");
        verify(mockedPrintStream, times(2)).println("3. Return a book");
        verify(mockedPrintStream, times(2)).println("Please Enter A Number");
        verify(mockedPrintStream, times(1)).println("harry potter\t,\t2003\t,\tJ.k rowling\n" +
                "Two states\t,\t2005\t,\tchetan bhagat\nWings of fire\t,\t2005\t,\tapj\n");
    }
}