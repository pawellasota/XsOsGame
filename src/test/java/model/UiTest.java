package model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class UiTest {

    Ui ui;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Scanner mockScanner;

    @BeforeEach
    void setUp() {
        Scanner mockScanner = mock(Scanner.class);
        ui = new Ui(mockScanner);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testIfPGetUserInputWorkProperly() {
        when(mockScanner.nextInt()).thenReturn(5);
        assertSame(5, ui.getUserInput());
}

    @Test
    public void testIfPGetUserInputWorkProperlyWithInt() {
        System.out.print(String.valueOf(1));
        assertEquals(String.valueOf(1), outContent.toString());
    }

    @Test
    public void testIfPGetUserInputWorkProperlyWithString() {
        ui.print("hello");
        assertEquals("hello", outContent.toString());
    }


}