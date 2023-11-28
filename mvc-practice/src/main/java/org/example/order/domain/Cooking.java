package org.example.order.domain;

public class Cooking {

    public Cook makeCook(final MenuItem menuItem) {
        return new Cook(menuItem);
    }

}
