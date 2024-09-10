public class ColorCard extends Card {

    public ColorCard(String color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor();
    }
}
