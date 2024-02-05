package org.example.view.views.view_menu.menu_model;

import java.util.function.Function;

public class LetterMenu extends AbstractMenu {

    public LetterMenu(String tittle) {
        super(tittle, toIndex(), toKey());
    }

    private static Function<String, Integer> toIndex() {
        return new Function<String, Integer>() {
            @Override
            public Integer apply(String key) {
                if (key.length() != 1) {
                    throw new IllegalArgumentException("");
                }
                return key.charAt(0) - 'a';
            }
        };
    }
    private static Function<Integer, String> toKey() {
        return new Function<Integer, String>() {
            @Override
            public String apply(Integer index) {
                char c = (char) (index + 'a');
                return String.valueOf(c);
            }
        };
    }

}
