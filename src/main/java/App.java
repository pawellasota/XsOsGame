import exception.InvalidCellNumberException;
import model.Game;
//import model.Ui;
import type.GameState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Game game = new Game();
//        Ui ui = new Ui();
        game.initGame();
        Integer cellNumber = 0;
        while(game.getCurrentState() == GameState.PLAYING) {
//            int cellNumber = ui.getUserInput();
            System.out.print(game.getCurrentPlayer());

           try {
               game.updateGameState(game.getCurrentPlayer(), cellNumber);
           } catch (InvalidCellNumberException e){
               System.out.println("Incorrect input. Try again");
               continue;
            }
            game.changePlayer();
           cellNumber++;
        }
    }
}
