package org.example.order.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CookTest {

    @DisplayName("요리 생성")
    @Test
    void 요리_생성() {
        // when & then
        assertThatCode(() -> new Cook("냉면", 5000))
                .doesNotThrowAnyException();
    }

}
