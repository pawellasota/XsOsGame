import model.Game;
import model.Ui;
import type.GameState;

public class App {

    public static void main(String[] args) {
        Game game = new Game();
        Ui ui = new Ui();
        game.initGame();
        while(game.getCurrentState() != GameState.PLAYING) {
            int [] coord = ui.getUserInput();
            game.updateGameState(game.getCurrentPlayer(), coord[0], coord[1]);

            game.changePlayer();
        }
    }
}
