package org.example;

import java.util.Objects;

public class RequestLine {

    private final String httpMethod; // GET
    private final String urlPath; // calculate ? operand1=10&operator=*&operand2=20
    private QueryStrings queryStrings; // operand1=10&operator=*&operand2=20

    public RequestLine(final String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.httpMethod = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    public RequestLine(final String httpMethod, final String urlPath, final String queryString) {
        this.httpMethod = httpMethod;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    public boolean isGetRequest() {
        return "GET".equals(httpMethod);
    }

    public boolean mathPath(final String requestPath) {
        return "/calculate".equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return queryStrings;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestLine that = (RequestLine) o;
        return Objects.equals(httpMethod, that.httpMethod) && Objects.equals(urlPath, that.urlPath)
                && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpMethod, urlPath, queryStrings);
    }

}
