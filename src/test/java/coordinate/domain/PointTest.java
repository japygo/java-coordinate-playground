package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("좌표를 생성한다")
    @Test
    void create() {
        Point actual = new Point(1, 2);
        assertThat(actual).isEqualTo(new Point(1, 2));
    }

    @DisplayName("X, Y좌표 모두 최대 24까지만 입력할 수 있다")
    @Test
    void validate() {
        assertThatThrownBy(() -> new Point(25, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x좌표는 0~24 사이의 수입니다.");
        assertThatThrownBy(() -> new Point(1, 25))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("y좌표는 0~24 사이의 수입니다.");
    }

    @DisplayName("두 좌표의 거리를 구한다")
    @Test
    void distance() {
        Point a = new Point(10, 10);
        Point b = new Point(14, 15);
        assertThat(a.getDistance(b)).isEqualTo(6.403124, Offset.offset(0.00099));
    }
}