package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestLineTest {

    @DisplayName("클라이언트 요청 객체 생성: HttpMethod, UrlPath, QueryString")
    @Test
    void 클라이언트_요청_객체_생성() {
        // given
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=10&operator=*&operand2=20 HTTP/1.1");

        // then
        assertThat(requestLine).isNotNull();
        assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=10&operator=*&operand2=20"));
    }

}
