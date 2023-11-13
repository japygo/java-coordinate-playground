package coordinate.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CoordinateCalculator {

    private CoordinateCalculator() {}

    public static double calculate(Coordinates coordinates) {
        if (coordinates.isLine()) {
            return distance(coordinates);
        }

        if (coordinates.isRectangle()) {
            return rectangleArea(coordinates);
        }

        return triangleArea(coordinates);
    }

    public static double distance(Coordinates coordinates) {
        List<Coordinate> coordinateList = coordinates.getCoordinates();

        Coordinate coordinate1 = coordinateList.get(0);
        Coordinate coordinate2 = coordinateList.get(1);

        return distance(coordinate1, coordinate2);
    }

    private static double distance(Coordinate coordinate, Coordinate coordinate2) {
        return Math.sqrt(
                Math.pow(coordinate.getDifferenceOfX(coordinate2), 2)
                        + Math.pow(coordinate.getDifferenceOfY(coordinate2), 2)
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

    public static double triangleArea(Coordinates coordinates) {
        List<Coordinate> coordinateList = coordinates.getCoordinates();

        Coordinate coordinate1 = coordinateList.get(0);
        Coordinate coordinate2 = coordinateList.get(1);
        Coordinate coordinate3 = coordinateList.get(2);

        return heron(
                distance(coordinate1, coordinate2),
                distance(coordinate2, coordinate3),
                distance(coordinate3, coordinate1)
        );
    }

    private static double heron(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
