package org.example.study;

public class PasswordValidator {

    private static final int MIN = 8;
    private static final int MAX = 12;

    public static void validate(final String password) {
        int length = password.length();
        if (length < MIN || length > MAX) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상 최대 12자 이하여야 한다.");
        }
    }

}
