package org.example.model.deck_factory;

import org.example.model.Deck;
import org.example.model.card.CardRank;

public class DeckFactory32Card extends BasicDeckFactory{

    public DeckFactory32Card() {
    }

    @Override
    public Deck get() {
        return getFrom(CardRank.SIX);
    }
}
