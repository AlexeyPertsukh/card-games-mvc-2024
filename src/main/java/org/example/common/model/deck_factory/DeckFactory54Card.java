package org.example.common.model.deck_factory;

import org.example.common.model.deck.Deck;
import org.example.common.model.card.CardRank;

public class DeckFactory54Card extends AbstractDeckFactory {

    public DeckFactory54Card() {
    }

    @Override
    public Deck get() {
        return getFrom(CardRank.TWO);
    }
}
