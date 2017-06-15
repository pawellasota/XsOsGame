import exception.InvalidCellNumberException;
import model.Game;
import model.Ui;
import type.GameState;
import java.util.InputMismatchException;


public class App {

    public static void main(String[] args) {
        Game game = new Game();
        game.initGame();
        while(game.getCurrentState() == GameState.PLAYING) {
            Ui.printRoundInfo(game.getCurrentPlayer());
            Ui.printBoard(game.getBoard().getCells());
           try {
               Integer cellNumber = Ui.getUserInput();
               game.updateGameState(game.getCurrentPlayer(), cellNumber);
           } catch (InvalidCellNumberException e){
               Ui.print("This field is already occupied . Try again");
               continue;
           } catch (ArrayIndexOutOfBoundsException e){
               Ui.print("Input number out of range. Try again");
               continue;
           }catch (InputMismatchException e){
               Ui.print("Wrong input. Only numbers allowed. Try again");
               continue;
           }
           if (game.getCurrentState() == GameState.PLAYING) {
               game.changePlayer();
           }
        }
        Ui.printBoard(game.getBoard().getCells());
        if (game.getCurrentState() == GameState.DRAW) {
            Ui.print("Draw");
        } else {
            Ui.print("Winner is "+game.getCurrentPlayer());
        }
    }
}
