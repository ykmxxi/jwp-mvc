package org.example.order.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuItemTest {

    @DisplayName("메뉴 항목 생성")
    @Test
    void 메뉴_항목_생성() {
        // when & then
        assertThatCode(() -> new MenuItem("냉면", 5000))
                .doesNotThrowAnyException();
    }

}
