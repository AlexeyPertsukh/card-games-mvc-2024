package org.example.model.card;

public class Card {
    private final CardRank rank;
    private final CardSuit suit;
    private boolean isOpen;

    public Card(CardRank rank, CardSuit suit) {
        this(rank, suit, false);
    }

    public Card(CardRank rank, CardSuit suit, boolean isOpen) {
        this.rank = rank;
        this.suit = suit;
        this.isOpen = isOpen;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }
}
