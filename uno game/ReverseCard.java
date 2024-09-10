public class ReverseCard extends ActionCard {

    public ReverseCard(String color) {
        super(color, "Reverse");
    }

    @Override
    public void apply(Game game) {
        game.isReversed = !game.isReversed;
    }
}
