package org.example.study;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "1234567890ab"})
    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 에러가 발생하지 않는다.")
    void 비밀번호_검증_통과(String password) {
        // when & then
        assertThatCode(() -> PasswordValidator.validate(password))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567", "1234567890abc"})
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    void 비밀번호_검증_실패() {
        // when & then
        assertThatCode(() -> PasswordValidator.validate("1234567"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 최대 12자 이하여야 한다.");
    }

}
