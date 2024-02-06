package org.example.common.view.views.view_menu.menu_model;

import java.util.function.Function;

public class NumericMenu extends AbstractMenu {

    public NumericMenu(String tittle) {
        super(tittle, toIndex(), toKey());
    }

    private static Function<String, Integer> toIndex() {
        return (n) -> Integer.parseInt(n) - 1;
    }

    private static Function<Integer, String> toKey() {
        return (n) -> String.valueOf(n + 1);
    }

}
