package org.example.common.model.deck_factory;

import org.example.common.model.deck.Deck;
import org.example.common.model.card.CardRank;

public class DeckFactory52Card extends AbstractDeckFactory {

    public DeckFactory52Card() {
    }

    @Override
    public Deck get() {
        return getFrom(CardRank.TWO);
    }
}
