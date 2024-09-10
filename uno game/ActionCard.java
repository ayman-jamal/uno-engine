public abstract class ActionCard extends Card {
    private String action;

    public ActionCard(String color, String action) {
        super(color);
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public abstract void apply(Game game);
}
