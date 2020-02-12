package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldCheckIfDisplayMenuMethodDisplaysEveryMenu() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Menu menu = new Menu(new Biblioteca(new ArrayList<>(), new ArrayList<>()), new Reader());

        menu.displayMenu();

        verify(mockedPrintStream, times(1)).println("Menu options");
        verify(mockedPrintStream, times(1)).println("1. Display List of all books");
        verify(mockedPrintStream, times(1)).println("2. Check out a book");
        verify(mockedPrintStream, times(1)).println("3. Return a book");
        verify(mockedPrintStream, times(1)).println("4. Quit Application");
        verify(mockedPrintStream, times(1)).println("Please Enter A Number");
    }

    @Test
    void shouldCheckIfListOfBooksIsDisplayed() {
        Reader reader = mock(Reader.class);
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        when(reader.getInt()).thenReturn(1);
        doReturn(true, false).when(reader).hasNext();
        Menu menu = new Menu(new Biblioteca(new ArrayList<>(), new ArrayList<>()), reader);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
    }

    @Test
    void shouldCheckIfInvalidNumberIsEnteredDisplayInvalidMessage() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Reader reader = mock(Reader.class);
        doReturn(22).when(reader).getInt();
        doReturn(true, false).when(reader).hasNext();
        Menu menu = new Menu(new Biblioteca(new ArrayList<>(), new ArrayList<>()), reader);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("Invalid option.Please Enter correct option!");
    }

    @Test
    void shouldCheckUserCanCheckOutABook() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        Reader reader = mock(Reader.class);
        doReturn(2).when(reader).getInt();
        doReturn("book1").when(reader).getString();
        doReturn(true, false).when(reader).hasNext();
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());
        Menu menu = new Menu(biblioteca, reader);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("Thank you! Enjoy the book.");
    }

    @Test
    void shouldNotCheckOutABookIfItIsInvalid() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Reader reader = mock(Reader.class);
        doReturn(2).when(reader).getInt();
        doReturn("jfugj").when(reader).getString();
        doReturn(true, false).when(reader).hasNext();
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());
        Menu menu = new Menu(biblioteca, reader);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
        verify(mockedPrintStream, times(1)).println("Sorry, that book is not available.");
    }

    @Test
    void shouldReturnABookIfItIsValid() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Reader reader = mock(Reader.class);
        doReturn(2, 3).when(reader).getInt();
        doReturn("book1", "book1").when(reader).getString();
        doReturn(true, true, false).when(reader).hasNext();
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());
        Menu menu = new Menu(biblioteca, reader);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("Thank you! Enjoy the book.");
        verify(mockedPrintStream, times(1)).println("Thank you for returning the book.");
    }

    @Test
    void shouldNotReturnABookIfItIsNotValid() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Reader reader = mock(Reader.class);
        doReturn(3).when(reader).getInt();
        doReturn("book1").when(reader).getString();
        doReturn(true, false).when(reader).hasNext();
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());
        Menu menu = new Menu(biblioteca, reader);

        menu.execute();

        verify(mockedPrintStream, times(1)).println("That is not a valid book to return.");
    }

}