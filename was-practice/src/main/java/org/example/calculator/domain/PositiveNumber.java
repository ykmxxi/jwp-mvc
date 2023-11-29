package org.example.calculator.domain;

import java.util.Objects;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
