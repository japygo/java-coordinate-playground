package coordinate.domain;

public class Point {
    private static final int MIN_POINT = 0;
    private static final int MAX_POINT = 24;

    private final int x;
    private final int y;

    public Point(int x, int y) {
        validatePoint(x, y);
        this.x = x;
        this.y = y;
    }

    private void validatePoint(int x, int y) {
        if (x < MIN_POINT || x > MAX_POINT) {
            throw new IllegalArgumentException("x좌표는 0~24 사이의 수입니다.");
        }
        if (y < MIN_POINT || y > MAX_POINT) {
            throw new IllegalArgumentException("y좌표는 0~24 사이의 수입니다.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
