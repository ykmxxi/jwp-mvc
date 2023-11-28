package org.example.gradecalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CourseTest {

    @ParameterizedTest
    @ValueSource(strings = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"})
    @DisplayName("학점은 A+ ~ F 까지 존재한다.")
    void 수강과목_생성_성공(String grade) {
        // when & then
        assertThatCode(() -> new Course("알고리즘", grade, 3))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"A-", "E"})
    @DisplayName("잘못된 학점을 입력하면 IllegalArgumentException 예외가 발생한다.")
    void 수강과목_생성_실패(String grade) {
        // when & then
        assertThatCode(() -> new Course("알고리즘", grade, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 학점입니다.");
    }

    @Test
    @DisplayName("학점 계산: 수강 학점 * 교과목 평점")
    void 학점_계산() {
        // given
        Course course = new Course("알고리즘", "A", 3);

        // when
        double result = course.calculateScore();

        // then
        assertThat(result).isEqualTo(12.0);
    }

}
