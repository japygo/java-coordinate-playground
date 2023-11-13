package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateCalculatorTest {

    @Test
    @DisplayName("선 길이를 계산한다")
    void distance() {
        Coordinates coordinates =
                new Coordinates(Arrays.asList(new Coordinate(10, 10), new Coordinate(14,15)));
        assertThat(CoordinateCalculator.distance(coordinates))
                .isEqualTo(6.403124, Offset.offset(0.00099));
    }

    @Test
    @DisplayName("사각형 넓이를 계산한다")
    void rectangleArea() {
        Coordinates coordinates =
                new Coordinates(Arrays.asList(
                        new Coordinate(10, 10), new Coordinate(22,10),
                        new Coordinate(22, 18), new Coordinate(10,18)
                ));
        assertThat(CoordinateCalculator.rectangleArea(coordinates))
                .isEqualTo(96, Offset.offset(0.00099));
    }
}