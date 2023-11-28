package org.example.order.domain;

public class Customer {

    public Cook order(final String name, final Menu menu, final Cooking cooking) {
        MenuItem menuItem = menu.choose(name);
        return cooking.makeCook(menuItem);
    }

}
