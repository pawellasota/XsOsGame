package model;

import controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import type.GameState;
import type.Seed;
import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    Game game;
    GameController gameController;

    @BeforeEach
    void setUp() {
        game = new Game();
        gameController = new GameController(game);
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
 }