package org.example.common.view.views.view_menu.menu_model;

import java.util.Iterator;
import java.util.List;

public interface Menu {

    int size();
    String tittle();

    void add(String text);
    void add(List<String> strings);

    String getValue(String key);

    String getKey(int index);

    List<String> keys();

    List<Item> items();

    class Item {
        public final String key;
        public final String value;

        public Item(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
