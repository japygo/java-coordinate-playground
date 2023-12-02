package coordinate.domain;

import java.util.function.Function;

public enum FigureType {
    LINE("선", 2, Line::new),
    TRIANGLE("삼각형", 3, Triangle::new),
    RECTANGLE("사각형", 4, Rectangle::new),
    ;

    private final String name;
    private final int size;
    private final Function<Points, Figure> function;

    FigureType(String name, int size, Function<Points, Figure> function) {
        this.name = name;
        this.size = size;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Function<Points, Figure> getFunction() {
        return function;
    }

    public boolean isSameSize(int size) {
        return this.size == size;
    }
}
