package org.example.common.model.deck_factory;

import org.example.common.model.deck.Deck;
import org.example.common.model.card.CardRank;

public class DeckFactory32Card extends AbstractDeckFactory {

    public DeckFactory32Card() {
    }

    @Override
    public Deck get() {
        return getFrom(CardRank.SIX);
    }
}
