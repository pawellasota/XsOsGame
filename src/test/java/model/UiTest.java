package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;



class UiTest {

    Ui ui;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        ui = new Ui();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testIfPGetUserInputWorkProperlyWithInt() {
        System.out.print(String.valueOf(1));
        assertEquals(String.valueOf(1), outContent.toString());
    }

    @Test
    public void testIfPGetUserInputWorkProperlyWithString() {
        System.out.println("hello");
        assertEquals("hello", outContent.toString());
    }
}