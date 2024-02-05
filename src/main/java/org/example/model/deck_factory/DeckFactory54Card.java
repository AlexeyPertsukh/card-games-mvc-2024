package org.example.model.deck_factory;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.card.CardRank;
import org.example.model.card.CardSuit;

public class DeckFactory54Card extends BasicDeckFactory{

    public DeckFactory54Card() {
    }

    @Override
    public Deck get() {
        return getFrom(CardRank.TWO);
    }
}
