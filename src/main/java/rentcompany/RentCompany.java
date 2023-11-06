package rentcompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private final List<Car> cars = new ArrayList<>();

    private RentCompany() {
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (Car car : cars) {
            report.append(car.getReport()).append("\n");
        }
        return report.toString();
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
