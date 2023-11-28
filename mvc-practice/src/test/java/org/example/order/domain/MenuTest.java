package org.example.order.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("메뉴이름에 해당하는 메뉴를 반환한다.")
    @Test
    void 메뉴_선택() {
        // given
        Menu menu = new Menu(List.of(new MenuItem("냉면", 5000), new MenuItem("돈까스", 4000)));

        // when
        MenuItem menuItem = menu.choose("냉면");

        // then
        assertThat(menuItem).isEqualTo(new MenuItem("냉면", 5000));
    }

    @DisplayName("존재하지 않는 메뉴이면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void 메뉴_선택_실패() {
        // given
        Menu menu = new Menu(List.of(new MenuItem("냉면", 5000), new MenuItem("돈까스", 4000)));

        // when & then
        assertThatCode(() -> menu.choose("치킨"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 메뉴입니다.");
    }

}
