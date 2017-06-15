package controller;

import exception.InvalidCellNumberException;
import model.Board;
import model.Game;
import view.Ui;
import type.GameState;
import type.Seed;
import java.util.InputMismatchException;
import java.util.Random;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
        this.initGame();
    }

    public void initGame() {
        this.game.setCurrentPlayer(pickPlayer());
        this.game.setCurrentState(GameState.PLAYING);
        this.game.setBoard(new Board());
        this.game.getBoard().init();
    }

    public Seed pickPlayer() {
        Seed[] players = Seed.values();
        Random random = new Random();
        Seed randomPlayer;
        randomPlayer = players[random.nextInt(players.length)];
        while (randomPlayer == Seed.EMPTY) {
            randomPlayer = players[random.nextInt(players.length)];
        }
        return randomPlayer;
    }

    public void changePlayer() {
        if (this.game.getCurrentPlayer() == Seed.CROSS) {
            this.game.setCurrentPlayer(Seed.NOUGHT);
        } else {
            this.game.setCurrentPlayer(Seed.CROSS);
        }
    }

    public void updateGameState(Seed seed, int cellNumber) throws InvalidCellNumberException, ArrayIndexOutOfBoundsException {
        if (this.game.getBoard().hasWon(seed, cellNumber)) {
            switch (seed) {
                case CROSS:
                    this.game.setCurrentState(GameState.CROSS_WON);
                case NOUGHT:
                    this.game.setCurrentState(GameState.NOUGHT_WON);
            }
        } else if (this.game.getBoard().isDraw()) {
            this.game.setCurrentState(GameState.DRAW);
        }
    }

    public void play() {
        while (this.game.getCurrentState() == GameState.PLAYING) {
            Ui.printRoundInfo(game.getCurrentPlayer());
            Ui.printBoard(game.getBoard().getCells());
            try {
                Integer cellNumber = Ui.getUserInput();
                this.updateGameState(game.getCurrentPlayer(), cellNumber);
            } catch (InvalidCellNumberException e) {
                Ui.print("This field is already occupied . Try again");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                Ui.print("Input number out of range. Try again");
                continue;
            } catch (InputMismatchException e) {
                Ui.print("Wrong input. Only numbers allowed. Try again");
                continue;
            }
            if (game.getCurrentState() == GameState.PLAYING) {
                this.changePlayer();
            }
        }
        Ui.printBoard(game.getBoard().getCells());
        if (game.getCurrentState() == GameState.DRAW) {
            Ui.print("Draw");
        } else {
            Ui.print("Winner is " + game.getCurrentPlayer());
        }
    }
}