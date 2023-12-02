package coordinate.domain;

public class Line extends AbstractFigure {
    public static final FigureType FIGURE_TYPE = FigureType.LINE;

    public Line(Points points) {
        super(points, FIGURE_TYPE);
    }

    @Override
    protected void validateFigure(Points points) {
        // Do nothing
    }

    @Override
    public double getArea() {
        return getPoints().getPoints().get(0).getDistance(getPoints().getPoints().get(1));
    }
}
