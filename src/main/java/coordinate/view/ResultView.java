package coordinate.view;

import coordinate.domain.Coordinates;

public class ResultView {
    private static final int MAX_NUM = 24;

    public void printCoordinates(Coordinates coordinates) {
        for (int yIndex = MAX_NUM; yIndex >= 0; yIndex--) {
            printCoordinates(coordinates, yIndex);
        }
    }

    private void printCoordinates(Coordinates coordinates, int index) {
        if (index != 0) {
            printLines(coordinates, index);
        }

        if (index == 0) {
            printLastLines();
        }
    }

    private void printLines(Coordinates coordinates, int yIndex) {
        print4size(getYAxis(yIndex));
        for (int xIndex = 1; xIndex <= MAX_NUM; xIndex++) {
            print2size(getCoordinateIndex(coordinates, xIndex, yIndex));
        }
        printEmptyLine();
    }

    private String getYAxis(int index) {
        if (index % 2 == 0) {
            return index + "|";
        }
        return "|";
    }

    private String getCoordinateIndex(Coordinates coordinates, int xIndex, int yIndex) {
        if (coordinates.isContain(xIndex, yIndex)) {
            return "*";
        }
        return " ";
    }

    private void printLastLines() {
        for (int xIndex = 0; xIndex <= MAX_NUM; xIndex++) {
            printXAxis(xIndex);
        }
        printEmptyLine();
        for (int xIndex = 0; xIndex <= MAX_NUM; xIndex++) {
            printEvenIndex(xIndex);
        }
        printEmptyLine();
    }

    private void printXAxis(int index) {
        if (index == 0) {
            print4size("+");
        }

        if (index != 0) {
            print2size("-");
        }
    }

    private void printEvenIndex(int index) {
        if (index % 2 == 0) {
            print4size(String.valueOf(index));
        }
    }

    private void print4size(String value) {
        System.out.printf("%4s", value);
    }

    private void print2size(String value) {
        System.out.printf("%2s", value);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printDistance(double distance) {
        System.out.println("두 점 사이 거리는 " + distance);
    }
}
