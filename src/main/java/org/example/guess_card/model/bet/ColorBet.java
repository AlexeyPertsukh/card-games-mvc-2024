package org.example.guess_card.model.bet;

import org.example.common.model.card.CardSuit;

public class ColorBet implements Bet{
    private final CardSuit.Color color;

    public ColorBet(CardSuit.Color color) {
        this.color = color;
    }

    @Override
    public CardSuit.Color get() {
        return color;
    }
}
