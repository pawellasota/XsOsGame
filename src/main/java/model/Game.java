package model;


import exception.InvalidCellNumberException;
import type.GameState;
import type.Player;
import type.Seed;
import java.util.Random;

public class Game {

    private Board board;
    private GameState currentState;
    private Seed currentPlayer;

    public Board getBoard() {
        return board;
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


    public Game() {
        board = new Board();
    }

    private Seed pickPlayer() {
        Seed[] players = Seed.values();
        Random random = new Random();
        return players[random.nextInt(players.length)];
    }

    public void changePlayer() {
        if (this.getCurrentPlayer() == Seed.CROSS) {
            this.setCurrentPlayer(Seed.NOUGHT);
        }
        else {
            this.setCurrentPlayer(Seed.CROSS);
        }
    }

    public void initGame() {
        this.setCurrentPlayer(pickPlayer());
        this.setCurrentState(GameState.PLAYING);
    }

    public void updateGameState(Seed seed, int cellNumber) throws InvalidCellNumberException {
        if (this.getBoard().hasWon(seed, cellNumber)) {
            switch(seed){
                case CROSS:
                    setCurrentState(GameState.CROSS_WON);
                case NOUGHT:
                    setCurrentState(GameState.NOUGHT_WON);
            }

        }
    }
}
