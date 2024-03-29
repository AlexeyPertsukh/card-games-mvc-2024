package org.example.common.model.card;

public enum CardRank {
    JOKER("JOKER"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");
    private final String label;

    CardRank(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
