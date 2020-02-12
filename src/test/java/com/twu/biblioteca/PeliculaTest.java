package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PeliculaTest {
    //Movies in spanish - pelicula

    @Test
    void shouldCheckIfColumnNamesIsDisplayedAfterDisplayMoviesIsCalled() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Pelicula pelicula = new Pelicula(new ArrayList<>());

        pelicula.DisplayMovies();

        verify(mockedPrintStream,times(1)).println("Movie Name\t\tYear released\t\tDirector\t\tRatings");
    }

}