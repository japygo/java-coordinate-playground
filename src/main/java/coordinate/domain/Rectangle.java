package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Rectangle extends AbstractFigure {
    public static final FigureType FIGURE_TYPE = FigureType.RECTANGLE;

    public Rectangle(Points points) {
        super(points, FIGURE_TYPE);
    }

    @Override
    protected void validateFigure(Points points) {
        if (!isRectangle(points)) {
            throw new IllegalArgumentException(errorMessage());
        }
    }

    private boolean isRectangle(Points points) {
        return points.getXs().size() == 2 && points.getYs().size() == 2;
    }

    @Override
    public double getArea() {
        double width = getDifference(getPoints().getXs());
        double height = getDifference(getPoints().getYs());
        return width * height;
    }

    private double getDifference(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        return Math.abs(list.get(0) - list.get(1));
    }
}
