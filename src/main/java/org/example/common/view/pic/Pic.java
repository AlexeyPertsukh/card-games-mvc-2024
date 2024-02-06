package org.example.common.view.pic;

import org.jetbrains.annotations.NotNull;

public class Pic {
    private final String[] value;

    public Pic(@NotNull String[] value) {
        this.value = value.clone();
    }

    public Pic(@NotNull String value) {
        this(new String[]{value});
    }

    public String get(int index) {
        return value[index];
    }

    public String[] value() {
        return value;
    }

    public int size() {
        return value().length;
    }
}

/* TODO check that the string does not change */