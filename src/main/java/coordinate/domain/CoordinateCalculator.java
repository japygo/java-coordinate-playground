package coordinate.domain;

import java.util.List;

public class CoordinateCalculator {

    private CoordinateCalculator() {}

    public static double distance(Coordinates coordinates) {
        List<Coordinate> coordinateList = coordinates.getCoordinates();

        Coordinate coordinate1 = coordinateList.get(0);
        Coordinate coordinate2 = coordinateList.get(1);

        return Math.sqrt(
                Math.pow(coordinate1.getDifferenceOfX(coordinate2), 2)
                        + Math.pow(coordinate1.getDifferenceOfY(coordinate2), 2)
        );
    }
}
