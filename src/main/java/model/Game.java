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

    public Game() {
//        gameController = new GameController();
    }


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



    private Seed pickPlayer() {
        Seed[] players = Seed.values();
        Random random = new Random();
        Seed randomPlayer;
        randomPlayer = players[random.nextInt(players.length)];
        while(randomPlayer == Seed.EMPTY) {
            randomPlayer = players[random.nextInt(players.length)];
        }
        return randomPlayer;
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
        this.board = new Board();
        this.board.init();
    }

    public void updateGameState(Seed seed, int cellNumber) throws InvalidCellNumberException, ArrayIndexOutOfBoundsException {
        if (this.getBoard().hasWon(seed, cellNumber)) {
            switch(seed){
                case CROSS:
                    setCurrentState(GameState.CROSS_WON);
                case NOUGHT:
                    setCurrentState(GameState.NOUGHT_WON);
            }
        } else if (this.getBoard().isDraw()) {
            this.setCurrentState(GameState.DRAW);
        }
    }
}

