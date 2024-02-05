package org.example.model.card;

import static org.example.model.card.CardSuit.Color.BLACK;
import static org.example.model.card.CardSuit.Color.RED;

public enum CardSuit {
    NONE_RED("R", RED),
    NONE_BLACK("B", BLACK),
    DIAMOND("♦", RED),
    HEART("♥", RED),
    CLUB("♣", BLACK),
    SPADE("♠", BLACK);
    private final String icon;
    private final Color color;

    CardSuit(String icon, Color color) {
        this.icon = icon;
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public Color getColor() {
        return color;
    }

    public boolean isNone() {
        return this == NONE_RED || this == NONE_BLACK;
    }

    public enum Color {
        BLACK,
        RED
    }
}
