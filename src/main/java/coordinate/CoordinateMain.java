package coordinate;

import coordinate.domain.CoordinateCalculator;
import coordinate.domain.Coordinates;
import coordinate.view.InputView;
import coordinate.view.ResultView;

public class CoordinateMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        Coordinates coordinates = inputView.enterCoordinate();
        resultView.printCoordinates(coordinates);
        resultView.printDistance(CoordinateCalculator.calculate(coordinates));
    }
}
