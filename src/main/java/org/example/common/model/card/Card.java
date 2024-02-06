package org.example.common.model.card;

public class Card {
    private final CardRank rank;
    private final CardSuit suit;
    private boolean isOpen;

    public Card(CardRank rank, CardSuit suit) {
        this(rank, suit, false);
    }

    public Card(CardRank rank, CardSuit suit, boolean isOpen) {
        validate(rank, suit);
        this.rank = rank;
        this.suit = suit;
        this.isOpen = isOpen;
    }

    private static void validate(CardRank rank, CardSuit suit) {
        if ((rank == CardRank.JOKER && !suit.isNone()) || (rank != CardRank.JOKER && suit.isNone())) {
            String message = String.format("illegal card: suit %s, rank %s", suit, rank);
            throw new IllegalArgumentException(message);
        }
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
