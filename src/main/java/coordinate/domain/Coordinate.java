package coordinate.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> integers = toInteger(value);
        validListSize(integers);
        return new Coordinate(integers.get(0), integers.get(1));
    }

    private void validSize(int value) {
        if (!isBetween(value)) {
            throw new IllegalArgumentException("좌표 값은 1 ~ 24 사이 입니다.");
        }
    }

    private static void validListSize(List<?> list) {
        if (!isSizeTwo(list)) {
            throw new IllegalArgumentException("좌표 값은 x,y 입니다.");
        }
    }

    public static boolean valid(String value) {
        if (!value.startsWith(PREFIX) || !value.endsWith(SUFFIX) || !value.contains(DELIMITER)) {
            return false;
        }

        List<Integer> integers = toInteger(value);
        return isSizeTwo(integers) && integers.stream().allMatch(Coordinate::isBetween);
    }

    private static boolean isBetween(int value) {
        return value >= 0 && value <= 24;
    }

    private static boolean isSizeTwo(List<?> list) {
        return list.size() == 2;
    }

    private static List<Integer> toInteger(String value) {
        return Arrays.stream(value.replace(PREFIX, "").replace(SUFFIX, "").split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getDifferenceOfX(Coordinate coordinate) {
        return coordinate.getDifferenceOfX(x);
    }

    private int getDifferenceOfX(int x) {
        return this.x - x;
    }

    public int getDifferenceOfY(Coordinate coordinate) {
        return coordinate.getDifferenceOfY(y);
    }

    private int getDifferenceOfY(int y) {
        return this.y - y;
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
