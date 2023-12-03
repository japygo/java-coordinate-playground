package coordinate.domain;

public interface Figure {
    Points getPoints();
    FigureType getType();
    double getArea();
    String getAreaInfo();
    boolean hasPoint(int xIndex, int yIndex);
}
