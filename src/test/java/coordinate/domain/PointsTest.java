package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointsTest {

    @DisplayName("좌표 리스트를 생성한다")
    @Test
    void create() {
        Points actual = new Points(List.of(new Point(1, 1), new Point(2, 2)));
        assertThat(actual).isEqualTo(new Points(List.of(new Point(1, 1), new Point(2, 2))));
        assertThat(actual.getPoints()).hasSize(2);
        assertThat(actual.getSize()).isEqualTo(2);
    }

    @DisplayName("좌표 리스트는 좌표가 있어야 한다")
    @Test
    void validate() {
        assertThatThrownBy(() -> new Points(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표가 비었습니다.");

        List<Point> emptyList = Collections.emptyList();
        assertThatThrownBy(() -> new Points(emptyList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표가 비었습니다.");
    }
}