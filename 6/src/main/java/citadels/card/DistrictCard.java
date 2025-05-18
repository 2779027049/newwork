package citadels.card;

public class DistrictCard {
    private final String name;
    private final int cost;

    public DistrictCard(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() { return name; }
    public int    getCost() { return cost; }

    @Override public String toString() {
        return name + "(" + cost + ")";
    }
}
