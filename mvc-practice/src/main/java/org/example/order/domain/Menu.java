package org.example.order.domain;

import java.util.List;

public class Menu {

    private final List<MenuItem> menuItems;

    public Menu(final List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(final String name) {
        return menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

}
