package coordinate.domain;

import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    private final Points points;
    private final FigureType type;

    protected AbstractFigure(Points points, FigureType type) {
        this.type = type;
        validateSize(points);
        validateDuplication(points);
        validateFigure(points);
        this.points = points;
    }

    private void validateSize(Points points) {
        if (!type.isSameSize(points.getSize())) {
            throw new IllegalArgumentException(errorMessage());
        }
    }

    private void validateDuplication(Points points) {
        if (points.isDuplicate()) {
            throw new IllegalArgumentException(errorMessage());
        }
    }

    protected abstract void validateFigure(Points points);

    protected String errorMessage() {
        return "잘못된 " + type.getName() + " 좌표입니다.";
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    public FigureType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractFigure that = (AbstractFigure) o;

        if (!Objects.equals(points, that.points)) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = points != null ? points.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
