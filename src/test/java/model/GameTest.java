package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import type.GameState;
import type.Seed;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
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