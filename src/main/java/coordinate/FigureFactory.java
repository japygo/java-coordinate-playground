package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static final Map<Integer, FigureType> figureTypeMap = new HashMap<>();

    static {
        figureTypeMap.put(2, FigureType.LINE);
        figureTypeMap.put(3, FigureType.TRIANGLE);
        figureTypeMap.put(4, FigureType.RECTANGLE);
    }

    private FigureFactory() {}

    static Figure getInstance(List<Point> points) {
        return figureTypeMap.get(points.size()).create(points);
    }
}
