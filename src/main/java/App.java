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
               System.out.println("This field is already occupied . Try again");
               continue;
           } catch (ArrayIndexOutOfBoundsException e){
               System.out.println("Input number out of range. Try again");
               continue;
           }
           if (game.getCurrentState() == GameState.PLAYING) {
               game.changePlayer();
           }
            Ui.printBoard(game.getBoard().getCells());
        }
        if (game.getCurrentState() == GameState.DRAW) {
            Ui.print("Draw");
        } else {
            Ui.print("Winner is "+game.getCurrentPlayer());
        }

    }
}
