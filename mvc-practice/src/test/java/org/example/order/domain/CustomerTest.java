package org.example.order.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @DisplayName("손님이 메뉴이름을 통해 요리를 주문한다.")
    @Test
    void 손님_메뉴_주문() {
        // given
        Customer customer = new Customer();
        Cooking cooking = new Cooking();
        Menu menu = new Menu(List.of(new MenuItem("냉면", 5000), new MenuItem("돈까스", 4000)));

        // when & then
        assertThatCode(() -> customer.order("냉면", menu, cooking))
                .doesNotThrowAnyException();
    }

}
