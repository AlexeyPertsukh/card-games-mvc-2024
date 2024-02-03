package org.example.model.card;

public enum CardSuit {
    DIAMOND("♦"),
    HEART("♥"),
    CLUB("♣"),
    SPADE("♠");
    private final String icon;

    CardSuit(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
