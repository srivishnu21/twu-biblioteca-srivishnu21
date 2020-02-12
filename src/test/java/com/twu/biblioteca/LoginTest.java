package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginTest {

    @Test
    void testShouldAsksForUserInformation() {
        Reader reader = mock(Reader.class);
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Login login = new Login(reader);

        login.executeLoginAction();

        verify(mockedPrintStream, times(1)).println("Please Enter your Biblioteca Number");
        verify(mockedPrintStream, times(1)).println("Please Enter your Biblioteca Password");
    }

    @Test
    void testShouldVerifyUserIsValidAndChecksMessageIsDisplayed() {
        Reader reader = mock(Reader.class);
        doReturn("123-6878", "password").when(reader).getString();
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Login login = new Login(reader);

        login.executeLoginAction();

        verify(mockedPrintStream, times(1)).println("You have successfully logged in");
        assertTrue(BibliotecaApp.isLoggedIn());
        assertEquals(BibliotecaApp.getUser(),new UserAccount("123-6878","password"));
    }

    @Test
    void testShouldVerifyUserIsInValidAndChecksMessageIsDisplayed() {
        Reader reader = mock(Reader.class);
        doReturn("123-4354", "sfgiuqasgfj").when(reader).getString();
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Login login = new Login(reader);

        login.executeLoginAction();

        verify(mockedPrintStream, times(1)).println("Entered password and library number is wrong. Please try again!");
        assertFalse(BibliotecaApp.isLoggedIn());
        assertNotEquals(BibliotecaApp.getUser(),new UserAccount("123-4354","sfgiuqasgfj"));
    }
}