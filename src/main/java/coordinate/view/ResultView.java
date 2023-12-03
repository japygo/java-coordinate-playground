package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;

public class ResultView {
    private static final String HORIZONTAL_AXIS = "----";
    private static final String VERTICAL_AXIS = "|";
    private static final String ORIGIN = "+";
    private static final String BLANK = " ";
    private static final String POINT = "*";

    private ResultView() {}

    public static void printCoordinates(Figure figure) {
        printVertical(figure);
        printHorizontalAxis();
        printHorizontalNumbers();
        printArea(figure);
    }

    private static void printVertical(Figure figure) {
        for (int yIndex = Point.MAX_POINT; yIndex > Point.MIN_POINT; yIndex--) {
            printNumber(yIndex);
            System.out.print(VERTICAL_AXIS);
            printPoint(figure, yIndex);
            printEmptyLine();
        }
    }

    private static void printPoint(Figure figure, int yIndex) {
        for (int xIndex = Point.MIN_POINT + 1; xIndex <= Point.MAX_POINT; xIndex++) {
            if (figure.hasPoint(xIndex, yIndex)) {
                print2size(POINT);
                print2size(BLANK);
                continue;
            }
            print4size(BLANK);
        }
    }

    private static void printHorizontalAxis() {
        System.out.print(BLANK);
        print4size(ORIGIN);
        for (int xIndex = Point.MIN_POINT + 1; xIndex <= Point.MAX_POINT; xIndex++) {
            System.out.print(HORIZONTAL_AXIS);
        }
        printEmptyLine();
    }

    private static void printHorizontalNumbers() {
        System.out.print(BLANK);
        print4size(BLANK);
        for (int xIndex = Point.MIN_POINT + 1; xIndex <= Point.MAX_POINT; xIndex++) {
            printNumber(xIndex);
        }
        printEmptyLine();
    }

    private static void printNumber(int index) {
        if (index % 2 == 0) {
            print4size(String.valueOf(index));
            return;
        }
        print4size(BLANK);
    }

    private static void print4size(String value) {
        System.out.printf("%4s", value);
    }

    private static void print2size(String value) {
        System.out.printf("%2s", value);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printArea(Figure figure) {
        System.out.println(figure.getAreaInfo());
    }
}
