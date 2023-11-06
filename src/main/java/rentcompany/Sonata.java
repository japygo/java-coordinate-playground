package rentcompany;

public class Sonata extends Car {
    private static final int FUEL_EFFICIENCY = 10;
    private static final String NAME = "Sonata";

    public Sonata(int distance) {
        super(distance, FUEL_EFFICIENCY, NAME);
    }
}
