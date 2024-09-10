public class SkipCard extends ActionCard {

    public SkipCard(String color) {
        super(color, "Skip");
    }

    @Override
    public void apply(Game game) {
        game.skipNextPlayer();
    }
}
