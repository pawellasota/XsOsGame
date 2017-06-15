package model;


import exception.InvalidCellNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import type.GameState;
import type.Seed;
import type.WinningRowsCoordinates;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BoardTest {
    Board board;
    Cell mockedCell;
    Game mockedGame;

    @BeforeEach
    void setUp() {

        board = new Board();
        mockedGame = mock(Game.class);
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

    @Test
    void testIfInitCreatesValidTable() {
        assertEquals(9, this.board.getCells().length);
    }

    @Test
    void testIfBadUserInputThrowsArrayIndexOutOfBoundsException() {
        Integer numberOutOfRange = 15;
        this.board.init();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.board.hasWon(Seed.CROSS, numberOutOfRange);
        });
    }

    @Test
    void testIfMarkAttemptOnAlreadyMarkedFieldThrowsInvalidCellNumberException() {
        this.board.init();
        this.board.getCells()[0].setContent(Seed.CROSS);
        Integer cellNumberAlreadyFilled = 0;
        assertThrows(InvalidCellNumberException.class, () -> {
            this.board.markField(Seed.CROSS, cellNumberAlreadyFilled);
        });
    }

    @Test
    void testIfMethodAllFieldsAreFilledReturnsTrueIfAllCellsAreFilled() {
        Cell[] cells = new Cell[]{mockedCell, mockedCell, mockedCell, mockedCell, mockedCell, mockedCell,
                mockedCell, mockedCell, mockedCell};
        this.board.setCells(cells);
        when(mockedCell.getContent()).thenReturn(Seed.CROSS);
        assertEquals(true, this.board.allFieldsAreFilled());
    }

//    @Test
//    void testIfUpdateGameStateSetsCROSS_WONGameState() throws Exception{
//        this.board.init();
//        this.board.getCells()[0].setContent(Seed.CROSS);
//        this.board.getCells()[3].setContent(Seed.CROSS);
//        this.board.getCells()[6].setContent(Seed.CROSS);
//        GameState expectedGameState = GameState.CROSS_WON;
//        assertEquals(expectedGameState, this.game.getCurrentState());
//    }

}