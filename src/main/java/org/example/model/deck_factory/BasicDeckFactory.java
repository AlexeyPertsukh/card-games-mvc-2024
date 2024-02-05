package org.example.model.deck_factory;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.card.CardRank;
import org.example.model.card.CardSuit;

public abstract class BasicDeckFactory  implements DeckFactory{
    protected Deck get(CardRank start) {
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
}
