package org.example.calculator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumberTest {

    @Test
    @DisplayName("사칙연산 계산기는 양수만 입력 가능하다.")
    void 양수_검증_성공() {
        // when & then
        assertThatCode(() -> new PositiveNumber(0))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("음수를 입력하면 IllegalArgumentException 예외가 발생한다.")
    void 양수_검증_실패() {
        assertThatThrownBy(() -> new PositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력할 수 있습니다.");
    }

}
