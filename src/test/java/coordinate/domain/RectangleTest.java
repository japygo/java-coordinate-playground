package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RectangleTest {

    @DisplayName("사각형을 생성한다")
    @Test
    void create() {
        Rectangle actual = new Rectangle(
                new Points(List.of(
                        new Point(1, 1),
                        new Point(2, 2),
                        new Point(1, 2),
                        new Point(2, 1)
                ))
        );
        assertThat(actual).isEqualTo(new Rectangle(
                new Points(List.of(
                        new Point(1, 1),
                        new Point(2, 2),
                        new Point(1, 2),
                        new Point(2, 1)
                ))
        ));
    }

    @DisplayName("좌표값은 네 개여야 한다")
    @Test
    void validatePointsSize() {
        Points points = new Points(List.of(new Point(1, 1)));
        assertThatThrownBy(() -> new Rectangle(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 사각형 좌표입니다.");
    }

    @DisplayName("좌표값은 직사각형으로 이루어져야 한다")
    @Test
    void validateLine() {
        Points points = new Points(List.of(
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4)
        ));
        assertThatThrownBy(() -> new Rectangle(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 사각형 좌표입니다.");
    }

    @DisplayName("사각형 넓이를 구한다")
    @Test
    void area() {
        Rectangle actual = new Rectangle(
                new Points(List.of(
                        new Point(10, 10),
                        new Point(22, 10),
                        new Point(22, 18),
                        new Point(10, 18)
                ))
        );
        assertThat(actual.getArea()).isEqualTo(96);
    }
}