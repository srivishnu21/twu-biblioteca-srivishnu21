package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    void shouldCheckIfDisplayWelcomeMessageIsPrintedOrNot() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BibliotecaApp.main(null);

        verify(mockedPrintStream, times(1)).println("Welcome to Biblioteca. " +
                "Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    void shouldCheckIfMenuExecuteMethodIsCalled() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        BibliotecaApp.main(null);

        verify(mockedPrintStream, times(2)).println("Menu options");
        verify(mockedPrintStream, times(2)).println("1. Display List of all books");
        verify(mockedPrintStream, times(2)).println("2. Check out a book");
        verify(mockedPrintStream, times(2)).println("3. Return a book");
        verify(mockedPrintStream, times(2)).println("Please Enter A Number");
        verify(mockedPrintStream, times(1)).println("harry potter\t,\t2003\t,\tJ.k rowling\n" +
                "Two states\t,\t2005\t,\tchetan bhagat\nWings of fire\t,\t2005\t,\tapj\n");
    }
}