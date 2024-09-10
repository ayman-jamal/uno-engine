public class DrawTwoCard extends ActionCard {

    public DrawTwoCard(String color) {
        super(color, "Draw Two");
    }

    @Override
    public void apply(Game game) {
        Player nextPlayer = game.getNextPlayer();
        game.drawCards(nextPlayer, 2);
        System.out.println(nextPlayer.getName() + " drew 2 cards.");
    }
}
