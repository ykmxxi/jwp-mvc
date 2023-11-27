package org.example.calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+:15", "-:5", "*:50", "/:2"}, delimiter = ':')
    @DisplayName("10과 5를 차례대로 사칙연산(덧셈, 뺄셈, 곱셈, 나눗셈) 계산")
    void 사칙연산_계산(String operator, int expected) {
        // given
        PositiveNumber operand1 = new PositiveNumber(10);
        PositiveNumber operand2 = new PositiveNumber(5);

        // when & then
        assertThat(Calculator.calculate(operator, operand1, operand2)).isEqualTo(expected);
    }

}
