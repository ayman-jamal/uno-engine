import java.util.ArrayList;
import java.util.List;

public class GameDriver {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));

        Game game = new ClassicUnoGame(players);
        game.play();
    }
}
