package controller;

import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import type.GameState;
import type.Seed;
import static org.junit.jupiter.api.Assertions.*;


class GameControllerTest {
    Game game;
    GameController gameController;

    @BeforeEach
    void setUp() {
        game = new Game();
        gameController = new GameController(game);
    }

    @Test
    void testIfPickPlayerFindValidPlayer() {
        assertEquals(this.gameController.pickPlayer().getClass(), Seed.class);
    }

    @Test
    void testIfChangePlayerChangesPlayerProperly() {
        game.setCurrentPlayer(Seed.CROSS);
        gameController.changePlayer();
        assertEquals(Seed.NOUGHT, this.game.getCurrentPlayer());
    }

    @Test
    void testIfInitSetsProperPlayer() {
        gameController.initGame();
        assertEquals(Seed.class, this.game.getCurrentPlayer().getClass());
    }

    @Test
    void testIfInitSetsProperGameState() {
        gameController.initGame();
        assertEquals(GameState.PLAYING, this.game.getCurrentState());
    }

    @Test
    void testIfInitSetsProperBoard() {
        gameController.initGame();
        int expectedBoardSize = 9;
        assertEquals(expectedBoardSize, game.getBoard().getCells().length);
    }

    @Test
    void testIfUpdateGameStateSetsNOUGHT_WONGameState() throws Exception{
        this.gameController.initGame();
        this.game.getBoard().getCells()[0].setContent(Seed.NOUGHT);
        this.game.getBoard().getCells()[3].setContent(Seed.NOUGHT);
        this.gameController.updateGameState(Seed.NOUGHT, 6);
        GameState expectedGameState = GameState.NOUGHT_WON;
        assertEquals(expectedGameState, this.game.getCurrentState());
    }
}