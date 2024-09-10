import java.util.Scanner;

public class WildCard extends ActionCard {

    public WildCard() {
        super("Wild", "Wild");
    }

    @Override
    public void apply(Game game) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a color: Red, Green, Blue, Yellow");
        String color = scanner.nextLine().trim();

        game.getDiscardPile().add(new ColorCard(color));
        System.out.println("The color has been changed to " + color);
    }
}
