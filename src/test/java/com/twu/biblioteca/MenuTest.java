package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldCheckIfDisplayMenuMethodDisplayEveryMenu() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu=new Menu();

        menu.displayMenu();

        verify(mockedPrintStream,times(1)).println("Menu options");
        verify(mockedPrintStream,times(1)).println("1.  Display List of all books");
        verify(mockedPrintStream,times(1)).println("Please Enter A Number");
    }
}