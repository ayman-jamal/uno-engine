import java.util.List;
import java.util.Scanner;

public class ClassicUnoGame extends Game {

    public ClassicUnoGame(List<Player> players) {
        super(players);
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Player currentPlayer = getCurrentPlayer();
            System.out.println("Current player: " + currentPlayer.getName());
            System.out.println("Top card: " + discardPile.getTopCard());

            System.out.println("Your hand:");
            for (int i = 0; i < currentPlayer.getHand().size(); i++) {
                System.out.println(i + ": " + currentPlayer.getHand().get(i));
            }

            System.out.print("Enter the index of the card to play (or -1 to draw): ");
            int index = scanner.nextInt();

            if (index == -1) {
                drawCards(currentPlayer, 1);
                System.out.println(currentPlayer.getName() + " drew a card.");
            } else {
                Card playedCard = currentPlayer.getHand().get(index);

                if (canPlayCard(playedCard)) {
                    currentPlayer.getHand().remove(index);

                    discardPile.add(playedCard);
                    System.out.println(currentPlayer.getName() + " played " + playedCard);

                    applyRules(playedCard, currentPlayer);

                    if (currentPlayer.getHand().isEmpty()) {
                        System.out.println(currentPlayer.getName() + " wins!");
                        break;
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            moveToNextPlayer();
        }

        scanner.close();
    }

    private boolean canPlayCard(Card card) {
        Card topCard = discardPile.getTopCard();

        if (topCard == null) {
            return true;
        }

        if (card instanceof WildCard || card instanceof WildDrawFourCard) {
            return true;
        }

        if (card.getColor().equals(topCard.getColor())) {
            return true;
        }

        if (card instanceof NumberCard && topCard instanceof NumberCard) {
            return ((NumberCard) card).getNumber() == ((NumberCard) topCard).getNumber();
        }

        if (card instanceof ActionCard && topCard instanceof ActionCard) {
            return ((ActionCard) card).getAction().equals(((ActionCard) topCard).getAction());
        }

        return false;
    }

}
