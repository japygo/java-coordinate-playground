package coordinate.domain;

public class Coordinate {
    private static final String PREFIX = "(";
    private static final String SUFFIX = ")";
    private static final String DELIMITER = ",";

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        validSize(x);
        validSize(y);
        this.x = x;
        this.y = y;
    }

    public static Coordinate from(String value) {
        String[] xy = value
                .replace(PREFIX, "")
                .replace(SUFFIX, "")
                .split(DELIMITER);
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        return new Coordinate(x, y);
    }

    private void validSize(int value) {
        if (value < 0 || value > 24) {
            throw new IllegalArgumentException("좌표 값은 1 ~ 24 사이 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
