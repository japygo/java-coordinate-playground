package coordinate;

import coordinate.view.InputView;
import coordinate.view.ResultView;

public class CoordinateMain {
    public static void main(String[] args) {
        ResultView.printCoordinates(InputView.inputCoordinates());
    }
}
