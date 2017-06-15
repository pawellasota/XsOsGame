package model;


import exception.InvalidCellNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import type.Seed;
import type.WinningRowsCoordinates;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BoardTest {
    Board board;
    Cell mockedCell;

    @BeforeEach
    void setUp() {

        board = new Board();
        mockedCell = mock(Cell.class);
        board.init();
    }

    @Test
    void testIfInitCreatesValidCells() {
        Cell[] expectedCells = new Cell[9];
        assertEquals(expectedCells.length, board.getCells().length);
    }

    @Test
    void testIfMarkFieldThrowsArrayIndexOutOfBoundsExceptionWhenCellNumberIsBelowZero() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            board.markField(Seed.CROSS, -1);
        });
    }

    @Test
    void testIfMarkFieldThrowsArrayIndexOutOfBoundsExceptionWhenCellNumberIsOutOfRange() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            board.markField(Seed.CROSS, 1000);
        });
    }

    @Test
    void testIfIsDrawReturnsFalseIfAllCellsAreNotFilled() {
        Boolean notDraw = board.isDraw();
        assertEquals(false, notDraw);
    }

    @Test
    void testIfIsDrawReturnsTrueIfAllCellsAreFilled() {
        Cell[] cells = new Cell[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = new Cell();
            cells[i].setContent(Seed.CROSS);
        }
        board.setCells(cells);
        assertEquals(true, board.isDraw());
    }

    @Test
    void testIfHasWonMethodThrowsArrayOutOfRangeException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            board.hasWon(Seed.CROSS, -1);
        });
    }

    @Test
    void testIfHasWonReturnsFalseIfPlayerNotWon() throws InvalidCellNumberException {
        int [] row = {1, 7, 6};
        assertFalse(board.isRowFilledWithSameSigns(row));
    }
}