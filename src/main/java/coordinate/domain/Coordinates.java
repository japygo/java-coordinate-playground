package coordinate.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coordinates {
    private static final String DELIMITER = "-";

    private final List<Coordinate> coordinates;

    public Coordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates(String value) {
        this.coordinates = Arrays.stream(value.split(DELIMITER))
                .map(Coordinate::from)
                .collect(Collectors.toList());
    }

    public static boolean valid(String coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            return false;
        }

        if (!coordinates.contains(DELIMITER)) {
            return false;
        }

        return Arrays.stream(coordinates.split(DELIMITER)).allMatch(Coordinate::valid);
    }

    public boolean isContain(int x, int y) {
        Coordinate coordinate = new Coordinate(x, y);
        return coordinates.stream().anyMatch(coordinate::equals);
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
