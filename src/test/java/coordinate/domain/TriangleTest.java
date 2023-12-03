package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TriangleTest {

    @DisplayName("삼각형을 생성한다")
    @Test
    void create() {
        Triangle actual = new Triangle(
                new Points(List.of(
                        new Point(1, 1),
                        new Point(2, 2),
                        new Point(1, 2)
                ))
        );
        assertThat(actual).isEqualTo(new Triangle(
                new Points(List.of(
                        new Point(1, 1),
                        new Point(2, 2),
                        new Point(1, 2)
                ))
        ));
    }

    @DisplayName("좌표값은 세 개여야 한다")
    @Test
    void validatePointsSize() {
        Points points = new Points(List.of(new Point(1, 1)));
        assertThatThrownBy(() -> new Triangle(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 삼각형 좌표입니다.");
    }

    @DisplayName("좌표값은 삼각형으로 이루어져야 한다")
    @Test
    void validateLine() {
        Points points = new Points(List.of(
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3)
        ));
        assertThatThrownBy(() -> new Triangle(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 삼각형 좌표입니다.");
    }

    @DisplayName("삼각형 넓이를 구한다")
    @Test
    void area() {
        Triangle actual = new Triangle(
                new Points(List.of(
                        new Point(10, 10),
                        new Point(14, 15),
                        new Point(20, 8)
                ))
        );
        assertThat(actual.getArea()).isEqualTo(29, Offset.offset(0.00099));
    }
}