package org.example;

public class QueryString {

    private final String key;
    private final String value;

    public QueryString(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public boolean exists(final String requestKey) {
        return requestKey.equals(this.key);
    }

    public String getValue() {
        return value;
    }

}
