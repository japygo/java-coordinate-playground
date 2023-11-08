package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinateTest {

    @Test
    @DisplayName("좌표를 생성한다")
    void create() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertThat(coordinate).isEqualTo(new Coordinate(1, 2));
    }

    @Test
    @DisplayName("좌표는 1 ~ 24 사이의 값이다")
    void valid() {
        assertThatThrownBy(() -> {
            new Coordinate(0, 25);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Coordinate(25, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("좌표 정보는 괄호 (, )로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다")
    void from() {
        Coordinate coordinate = Coordinate.from("(1,2)");
        assertThat(coordinate).isEqualTo(new Coordinate(1, 2));
    }

    @Test
    @DisplayName("좌표는 1 ~ 24 사이의 값이다")
    void valid_from() {
        assertThatThrownBy(() -> {
            Coordinate.from("(1,25)");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("좌표 정보가 올바른지 확인한다")
    @CsvSource(value = {
            "(1,2) : true", "1,2) : false", "(1,2 : false", "(12) : false",
            "(1,25) : false", "(25,1) : false", "(1,2,3) : false"},
            delimiter = ':')
    void valid_util(String coordinate, boolean result) {
        assertThat(Coordinate.valid(coordinate)).isEqualTo(result);
    }
}