package org.example.common.model.deck_factory;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.card.CardSuit;
import org.example.common.model.deck.Deck;

public class DeckFactory54Card extends AbstractDeckFactory {

    public DeckFactory54Card() {
    }

    @Override
    public Deck get() {
        Deck deck = getFrom(CardRank.TWO);
        deck.add(new Card(CardRank.JOKER, CardSuit.NONE_BLACK));
        deck.add(new Card(CardRank.JOKER, CardSuit.NONE_RED));
        return deck;
    }
}
