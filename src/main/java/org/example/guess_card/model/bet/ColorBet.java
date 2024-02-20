package org.example.guess_card.model.bet;

import org.example.common.model.card.CardSuit;

public class ColorBet extends AbstractBet<CardSuit.Color>{
    public ColorBet(CardSuit.Color value, String description) {
        super(value, description);
    }
}
