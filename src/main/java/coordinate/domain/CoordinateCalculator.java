package coordinate.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CoordinateCalculator {

    private CoordinateCalculator() {}

    public static double calculate(Coordinates coordinates) {
        if (coordinates.isLine()) {
            return distance(coordinates);
        }

        return rectangleArea(coordinates);
    }

    public static double distance(Coordinates coordinates) {
        List<Coordinate> coordinateList = coordinates.getCoordinates();

        Coordinate coordinate1 = coordinateList.get(0);
        Coordinate coordinate2 = coordinateList.get(1);

        return Math.sqrt(
                Math.pow(coordinate1.getDifferenceOfX(coordinate2), 2)
                        + Math.pow(coordinate1.getDifferenceOfY(coordinate2), 2)
        );
    }

    public static double rectangleArea(Coordinates coordinates) {
        List<Coordinate> coordinateList = coordinates.getCoordinates();

        double width = coordinateList.stream()
                .map(Coordinate::getX)
                .collect(Collectors.toSet()).stream()
                .reduce((integer, integer2) -> integer - integer2)
                .orElseThrow(RuntimeException::new);

        double height = coordinateList.stream()
                .map(Coordinate::getY)
                .collect(Collectors.toSet()).stream()
                .reduce((integer, integer2) -> integer - integer2)
                .orElseThrow(RuntimeException::new);

        return width * height;
    }
}
