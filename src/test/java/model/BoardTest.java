package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testIfInitCreatesValidCells() {
        board.init();
        Cell[][] expectedCells = new Cell[3][3];
        assertArrayEquals(expectedCells, board.getCells());
    }


}