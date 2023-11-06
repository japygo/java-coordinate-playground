package rentcompany;

public class Car implements Vehicle {
    private final int distance;
    private final int fuelEfficiency;
    private final String name;

    public Car(int distance, int fuelEfficiency, String name) {
        this.distance = distance;
        this.fuelEfficiency = fuelEfficiency;
        this.name = name;
    }

    @Override
    public int getFuelAmount() {
        return distance / fuelEfficiency;
    }

    @Override
    public String getReport() {
        return name + " : " + getFuelAmount() + "리터";
    }
}
