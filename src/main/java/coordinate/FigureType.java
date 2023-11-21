package coordinate;

import java.util.List;
import java.util.function.Function;

public enum FigureType {
    LINE(2, Line::new),
    TRIANGLE(3, Triangle::new),
    RECTANGLE(4, Rectangle::new),
    ;

    private final int size;
    private final Function<List<Point>, Figure> figureFunction;

    FigureType(int size, Function<List<Point>, Figure> figureFunction) {
        this.size = size;
        this.figureFunction = figureFunction;
    }

    public Figure create(List<Point> points) {
        if (points.size() != size) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
        return this.figureFunction.apply(points);
    }
}
