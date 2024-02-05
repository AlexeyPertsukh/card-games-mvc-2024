package org.example.view.views.view_menu.menu_model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractMenu implements Menu {
    private final String tittle;
    private final Function<String, Integer> toIndex;
    private final Function<Integer, String> toKey;
    private final List<String> values = new ArrayList<>();

    protected AbstractMenu(String tittle, Function<String, Integer> toIndex, Function<Integer, String> toKey) {
        this.tittle = tittle;
        this.toIndex = toIndex;
        this.toKey = toKey;
    }


    @Override
    public int size() {
        return values.size();
    }

    @Override
    public String tittle() {
        return tittle;
    }

    @Override
    public void add(String text) {
        values.add(text);
    }

    @Override
    public String getValue(String key) {
        int index = toIndex.apply(key);
        return values.get(index);
    }

    @Override
    public String getKey(int index) {
        return toKey.apply(index);
    }

    @Override
    public List<Item> items() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            String value = values.get(i);
            String key = toKey.apply(i);
            Item item = new Item(key, value);
            items.add(item);
        }

        return items;
    }

    @Override
    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            keys.add(toKey.apply(i));
        }
        return keys;
    }


}
