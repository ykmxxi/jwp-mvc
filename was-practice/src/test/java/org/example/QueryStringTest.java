package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueryStringTest {

    @DisplayName("쿼리 생성: 인자가 1개일 때")
    @Test
    void 쿼리_스트링_생성() {
        // given
        QueryString queryString = new QueryString("operand1", "10");

        // then
        assertThat(queryString).isNotNull();
    }

}
