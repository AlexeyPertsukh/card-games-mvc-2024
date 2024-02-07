package org.example.common.model.deck_factory;

import org.example.common.model.card.CardRank;
import org.example.common.model.deck.Deck;

public class DeckFactoryFullCard extends AbstractDeckFactory {

    public DeckFactoryFullCard() {
    }

    @Override
    public Deck get() {
        return getFrom(CardRank.values()[0]);
    }
}
