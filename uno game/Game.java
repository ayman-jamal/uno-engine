import java.util.List;

public abstract class Game {
    protected List<Player> players;
    protected DiscardPile discardPile;
    protected DrawPile drawPile;
    protected int currentPlayerIndex;
    protected boolean isReversed = false;

    public Game(List<Player> players) {
        this.players = players;
        this.discardPile = new DiscardPile();
        this.drawPile = new DrawPile();
        this.currentPlayerIndex = 0;

        for (Player player : players) {
            drawCards(player, 7);
        }

        discardPile.add(drawPile.draw());
    }

    public abstract void play();

    protected Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    protected void moveToNextPlayer() {
        if (isReversed) {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    protected void drawCards(Player player, int count) {
        for (int i = 0; i < count; i++) {
            if (drawPile.isEmpty()) {
                drawPile.refillFrom(discardPile);
            }
            player.addCard(drawPile.draw());
        }
    }

    protected void applyRules(Card playedCard, Player currentPlayer) {
        if (playedCard instanceof ActionCard) {
            ((ActionCard) playedCard).apply(this);
        }
    }

    protected Player getNextPlayer() {
        int nextPlayerIndex = isReversed ?
                (currentPlayerIndex - 1 + players.size()) % players.size() :
                (currentPlayerIndex + 1) % players.size();
        return players.get(nextPlayerIndex);
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public void skipNextPlayer() {
        moveToNextPlayer();
    }
}
