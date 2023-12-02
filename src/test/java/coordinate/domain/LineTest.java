package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("선을 생성한다")
    @Test
    void create() {
        Line actual = new Line(new Points(List.of(new Point(1, 1), new Point(2, 2))));
        assertThat(actual).isEqualTo(new Line(new Points(List.of(new Point(1, 1), new Point(2, 2)))));
    }

    @DisplayName("좌표값은 두 개여야 한다")
    @Test
    void validatePointsSize() {
        Points points = new Points(List.of(new Point(1, 1), new Point(2, 2), new Point(3, 3)));
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 선 좌표입니다.");
    }

    @DisplayName("좌표값은 선으로 이루어져야 한다")
    @Test
    void validateLine() {
        Points points = new Points(List.of(new Point(1, 1), new Point(1, 1)));
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 선 좌표입니다.");
    }

    @DisplayName("선 길이를 구한다")
    @Test
    void area() {
        Line actual = new Line(new Points(List.of(new Point(10, 10), new Point(14, 15))));
        assertThat(actual.getArea()).isEqualTo(6.403124, Offset.offset(0.00099));
    }
}