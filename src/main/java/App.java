import exception.InvalidCellNumberException;
import model.Game;
//import model.Ui;
import model.Ui;
import type.GameState;


public class App {

    public static void main(String[] args) {
        Game game = new Game();
        game.initGame();
        Integer cellNumber = 0;
        while(game.getCurrentState() == GameState.PLAYING) {
            System.out.println(game.getCurrentPlayer());
            cellNumber = Ui.getUserInput();
           try {
               game.updateGameState(game.getCurrentPlayer(), cellNumber);
           } catch (InvalidCellNumberException e){
               System.out.println("Incorrect input. Try again");
               continue;
            }
            Ui.printBoard(game.getBoard().getCells());

            game.changePlayer();
        }
    }
}
