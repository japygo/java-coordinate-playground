package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern coordinatePattern =
            Pattern.compile("(\\(\\d{1,2},\\d{1,2}\\))(-\\(\\d{1,2},\\d{1,2}\\)){1,3}");
    private static final Pattern pointsPattern = Pattern.compile("(\\(\\d{1,2},\\d{1,2}\\))");
    private static final Pattern pointPattern = Pattern.compile("\\((\\d{1,2}),(\\d{1,2})\\)");

    private InputView() {}

    public static Figure inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        return getFigure(scanner.next());
    }

    private static Figure getFigure(String coordinates) {
        try {
            validateCoordinates(coordinates);
            return toPoints(coordinates).toFigure();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static void validateCoordinates(String coordinates) {
        Matcher matcher = coordinatePattern.matcher(coordinates);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        }
    }

    private static Points toPoints(String coordinates) {
        Matcher matcher = pointsPattern.matcher(coordinates);
        List<Point> points = new ArrayList<>();
        while (matcher.find()) {
            points.add(toPoint(matcher.group()));
        }
        return new Points(points);
    }

    private static Point toPoint(String point) {
        Matcher matcher = pointPattern.matcher(point);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        }
        return new Point(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2))
        );
    }
}
