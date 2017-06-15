package model;


import type.GameState;
import type.Seed;

public class Game {

    private Board board;
    private GameState currentState;
    private Seed currentPlayer;

    public Game() {
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public void setCurrentPlayer(Seed currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }
}

