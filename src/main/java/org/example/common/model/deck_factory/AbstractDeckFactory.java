package org.example.common.model.deck_factory;

import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.card.CardSuit;

public abstract class AbstractDeckFactory implements DeckFactory{
    protected Deck getFrom(CardRank start) {
        Deck deck = new Deck();
        int startIndex = start.ordinal();
        CardRank[] ranks = CardRank.values();
        CardSuit[] suits = CardSuit.values();

        for (int i = startIndex; i < ranks.length; i++) {
            for (CardSuit suit : suits) {
                if(suit.isNone()) {
                    continue;
                }
                Card card = new Card(ranks[i], suit);
                deck.add(card);
            }
        }
        return deck;
    }

    @Override
    public Deck shoes(int num) {
        Deck deck = new Deck();
        for (int i = 0; i < num; i++) {
            deck.add(get());
        }
        return deck;
    }
}
