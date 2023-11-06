package rentcompany;

public class Avante extends Car {
    private static final int FUEL_EFFICIENCY = 15;
    private static final String NAME = "Avante";


    public Avante(int distance) {
        super(distance, FUEL_EFFICIENCY, NAME);
    }
}
