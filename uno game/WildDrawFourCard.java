import java.util.Scanner;

public class WildDrawFourCard extends ActionCard {

    public WildDrawFourCard() {
        super("Wild Draw Four", "WildDrawFour");
    }

    @Override
    public void apply(Game game) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a color: Red, Green, Blue, Yellow");
        String color = scanner.nextLine().trim();

        game.getDiscardPile().add(new ColorCard(color));
        System.out.println("The color has been changed to " + color);

        Player nextPlayer = game.getNextPlayer();
        game.drawCards(nextPlayer, 4);
        System.out.println(nextPlayer.getName() + " drew 4 cards.");

        game.skipNextPlayer();
    }
}
