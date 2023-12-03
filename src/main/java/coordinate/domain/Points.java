package coordinate.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("좌표가 비었습니다.");
        }
    }

    public boolean isDuplicate() {
        return points.size() != new HashSet<>(points).size();
    }

    public Figure toFigure() {
        return getFigureType()
                .getFunction()
                .apply(this);
    }

    private FigureType getFigureType() {
        return Arrays.stream(FigureType.values())
                .filter(type -> type.isSameSize(getSize()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 도형입니다."));
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getSize() {
        return points.size();
    }

    public Set<Integer> getXs() {
        return points.stream()
                .map(Point::getX)
                .collect(Collectors.toSet());
    }

    public Set<Integer> getYs() {
        return points.stream()
                .map(Point::getY)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Points points1 = (Points) o;

        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }
}
