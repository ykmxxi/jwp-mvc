package org.example.reflection;

import java.util.Objects;

public class User {

    private final String userId;
    private final String name;

    public User(final String userId, final String name) {
        this.userId = userId;
        this.name = name;
    }

    public boolean equalsUser(final User user) {
        return this.equals(user);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }

}
