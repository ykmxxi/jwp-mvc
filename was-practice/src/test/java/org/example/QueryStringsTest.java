package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueryStringsTest {

    @DisplayName("쿼리를 받아 여러개의 쿼리 스트링으로 변환")
    @Test
    void 쿼리_스트링_일급_콜렉션_생성() {
        // given
        QueryStrings queryStrings = new QueryStrings("operand1=10&operator=*&operand2=20");

        // then
        assertThat(queryStrings).isNotNull();
    }

}
