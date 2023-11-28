package org.example.order.domain;

import java.util.Objects;

public class MenuItem {

    private final String name;
    private final int price;

    public MenuItem(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public boolean matches(final String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuItem menuItem = (MenuItem) o;
        return getPrice() == menuItem.getPrice() && Objects.equals(getName(), menuItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

}
