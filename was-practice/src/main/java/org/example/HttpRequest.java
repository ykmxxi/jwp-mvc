package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {

    private final RequestLine requestLine;

    public HttpRequest(final BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(final String requestPath) {
        return requestLine.mathPath(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }

}
