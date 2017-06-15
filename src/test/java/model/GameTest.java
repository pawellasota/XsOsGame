package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import type.GameState;
import type.Seed;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    Game game;
    Board mockedBoard;
    Cell mockedCell;
    Cell[] cells;
    Cell[] mockedCells;

    @BeforeEach
    void setUp() {
        game = new Game();
        mockedBoard = mock(Board.class, Mockito.RETURNS_DEEP_STUBS);
        mockedCell = mock(Cell.class);
        mockedCells = new Cell[]{mockedCell, mockedCell, mockedCell, mockedCell, mockedCell, mockedCell,
                mockedCell, mockedCell, mockedCell};
    }

    @Test
    void testIfCurrentPlayerSetProperly() {
        game.setCurrentPlayer(Seed.EMPTY);
        assertEquals(Seed.EMPTY, game.getCurrentPlayer());
    }

    @Test
    void testIfCurrentStateSetProperly() {
        game.setCurrentState(GameState.DRAW);
        assertEquals(GameState.DRAW, game.getCurrentState());
    }

    @Test
    void testIfPickPlayerFindValidPlayer() {
        assertEquals(this.game.pickPlayer().getClass(), Seed.class);
    }

    @Test
    void testIfChangePlayerChangesPlayerProperly() {
        game.setCurrentPlayer(Seed.CROSS);
        game.changePlayer();
        assertEquals(Seed.NOUGHT, this.game.getCurrentPlayer());
    }

    @Test
    void testIfInitSetsProperPlayer() {
        game.initGame();
        assertEquals(Seed.class, this.game.getCurrentPlayer().getClass());
    }

    @Test
    void testIfInitSetsProperGameState() {
        game.initGame();
        assertEquals(GameState.PLAYING, this.game.getCurrentState());
    }

    @Test
    void testIfInitSetsProperBoard() {
        game.initGame();
        int expectedBoardSize = 9;
        assertEquals(expectedBoardSize, game.getBoard().getCells().length);
    }

    @Test
    void testIfUpdateGameStateSetsNOUGHT_WONGameState() throws Exception{
        this.game.initGame();
        this.game.getBoard().getCells()[0].setContent(Seed.NOUGHT);
        this.game.getBoard().getCells()[3].setContent(Seed.NOUGHT);
        this.game.updateGameState(Seed.NOUGHT, 6);
        GameState expectedGameState = GameState.NOUGHT_WON;
        assertEquals(expectedGameState, this.game.getCurrentState());
    }
 }

