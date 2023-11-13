package coordinate.view;

import coordinate.domain.Coordinates;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public Coordinates enterCoordinate() {
        System.out.println("좌표를 입력하세요.");
        String coordinate = scanner.next();

        while (!Coordinates.valid(coordinate)) {
            System.out.println("좌표를 다시 입력하세요.");
            coordinate = scanner.next();
        }

        Coordinates coordinates = new Coordinates(coordinate);
        if (!coordinates.isLine() && !coordinates.isRectangle() && !coordinates.isTriangle()) {
            return enterCoordinate();
        }

        return coordinates;
    }
}
