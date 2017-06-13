import model.Game;
import model.Ui;
import type.GameState;

public class App {

    public static void main(String[] args) {
        Game game = new Game();
        Ui ui = new Ui();
        game.initGame();
        while(game.getCurrentState() != GameState.PLAYING) {
            int cellNumber = ui.getUserInput();
            game.updateGameState(game.getCurrentPlayer(), cellNumber);

            game.changePlayer();
        }
    }
}
