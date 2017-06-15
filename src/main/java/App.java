import controller.GameController;
import model.Game;

public class App {

    public static void main(String[] args) {
        Game game = new Game();
        new GameController(game).play();
    }
}
