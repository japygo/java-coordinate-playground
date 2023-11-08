package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesTest {

    @Test
    @DisplayName("좌표 정보를 검사한다")
    void valid() {
        String coordinates = "(1,2)-(3,4)";
        assertThat(Coordinates.valid(coordinates)).isTrue();
    }

    @Test
    @DisplayName("좌표 정보는 빈 값일 수 없다")
    void valid_empty() {
        String coordinates = "";
        assertThat(Coordinates.valid(coordinates)).isFalse();
    }

    @Test
    @DisplayName("좌표값과 좌표값 사이는 '-' 문자로 구분한다")
    void valid_hyphen() {
        String coordinates = "(1,2)(3,4)";
        assertThat(Coordinates.valid(coordinates)).isFalse();
    }

    @Test
    @DisplayName("좌표 정보는 괄호 '(', ')'로 둘러쌓여 있다")
    void valid_prefix() {
        String coordinates = "1,2-(3,4)";
        assertThat(Coordinates.valid(coordinates)).isFalse();
    }

    @Test
    @DisplayName("좌표 정보는 쉼표(,)로 x값과 y값을 구분한다")
    void valid_comma() {
        String coordinates = "(12)-(3,4)";
        assertThat(Coordinates.valid(coordinates)).isFalse();
    }
}