package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateCalculatorTest {

    @Test
    void distance() {
        Coordinates coordinates =
                new Coordinates(Arrays.asList(new Coordinate(10, 10), new Coordinate(14,15)));
        assertThat(CoordinateCalculator.distance(coordinates))
                .isEqualTo(6.403124, Offset.offset(0.00099));
    }
}