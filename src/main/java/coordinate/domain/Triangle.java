package coordinate.domain;

public class Triangle extends AbstractFigure {
    public static final FigureType FIGURE_TYPE = FigureType.TRIANGLE;

    public Triangle(Points points) {
        super(points, FIGURE_TYPE);
    }

    @Override
    protected void validateFigure(Points points) {
        Lines lines = Lines.from(points);

        double sum = lines.firstLine + lines.secondLine + lines.thirdLine;
        double max = Math.max(Math.max(lines.firstLine, lines.secondLine), lines.thirdLine);

        if (sum - max <= max) {
            throw new IllegalArgumentException(errorMessage());
        }
    }

    @Override
    public double getArea() {
        Lines lines = Lines.from(getPoints());
        return heron(lines.firstLine, lines.secondLine, lines.thirdLine);
    }

    @Override
    public String getAreaInfo() {
        return "삼각형 넓이는 " + getArea();
    }

    private double heron(double firstLine, double secondLine, double thirdLine) {
        double s = (firstLine + secondLine + thirdLine) / 2;
        return Math.sqrt(s * (s - firstLine) * (s - secondLine) * (s - thirdLine));
    }

    private static class Lines {
        private final double firstLine;
        private final double secondLine;
        private final double thirdLine;

        private Lines(double firstLine, double secondLine, double thirdLine) {
            this.firstLine = firstLine;
            this.secondLine = secondLine;
            this.thirdLine = thirdLine;
        }

        public static Lines from(Points points) {
            Point firstPoint = points.getPoints().get(0);
            Point secondPoint = points.getPoints().get(1);
            Point thirdPoint = points.getPoints().get(2);

            double firstLine = firstPoint.getDistance(secondPoint);
            double secondLine = secondPoint.getDistance(thirdPoint);
            double thirdLine = thirdPoint.getDistance(firstPoint);

            return new Lines(firstLine, secondLine, thirdLine);
        }
    }
}
