package org.example.common.model.deck_factory;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.card.CardSuit;

public abstract class AbstractDeckFactory implements DeckFactory{
    protected org.example.common.model.deck.Deck getFrom(CardRank start) {
        org.example.common.model.deck.Deck deck = new org.example.common.model.deck.Deck();
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
    public org.example.common.model.deck.Deck shoes(int num) {
        org.example.common.model.deck.Deck deck = new org.example.common.model.deck.Deck();
        for (int i = 0; i < num; i++) {
            deck.add(get());
        }
        return deck;
    }

    @Override
    public org.example.common.model.deck.Deck getRandom(int num) {
        org.example.common.model.deck.Deck deck = get();
        deck.shuffle();
        return deck.take(num);
    }
}
