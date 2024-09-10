import java.util.ArrayList;
import java.util.List;

public class DiscardPile {
    private List<Card> cards;

    public DiscardPile() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Card getTopCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public List<Card> getAllCards() {
        return new ArrayList<>(cards);
    }

    public void clear() {
        cards.clear();
    }
}
