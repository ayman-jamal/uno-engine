import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawPile {
    private List<Card> cards;

    public DrawPile() {
        this.cards = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};

        for (String color : colors) {
            for (int i = 0; i <= 9; i++) {
                cards.add(new NumberCard(color, i));
                if (i != 0) {
                    cards.add(new NumberCard(color, i));
                }
            }
        }

        for (String color : colors) {
            cards.add(new SkipCard(color));
            cards.add(new ReverseCard(color));
            cards.add(new DrawTwoCard(color));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard());
            cards.add(new WildDrawFourCard());
        }

        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Draw pile is empty!");
        }
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void refillFrom(DiscardPile discardPile) {
        if (discardPile.isEmpty()) {
            throw new IllegalStateException("Discard pile is empty, cannot refill draw pile!");
        }
        cards.addAll(discardPile.getAllCards());
        discardPile.clear();
        Collections.shuffle(cards);
    }
}
