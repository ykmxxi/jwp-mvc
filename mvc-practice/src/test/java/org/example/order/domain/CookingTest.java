package org.example.order.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CookingTest {

    @DisplayName("요리사가 메뉴에 해당하는 음식을 조리한다.")
    @Test
    void 요리사_음식_조리() {
        // given
        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("냉면", 5000);

        // when
        Cook cook = cooking.makeCook(menuItem);

        // then
        assertThat(cook).isEqualTo(new Cook("냉면", 5000));
    }

}
