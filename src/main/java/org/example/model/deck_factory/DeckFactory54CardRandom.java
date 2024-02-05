package org.example.model.deck_factory;

import org.example.model.Deck;
import org.example.model.card.CardRank;

public class DeckFactory54CardRandom extends BasicDeckFactory{
    private final int num;
    public DeckFactory54CardRandom(int num) {
        this.num = num;
    }

    @Override
    public Deck get() {
        Deck deck = getFrom(CardRank.TWO);
        deck.shuffle();
        Deck out = new Deck();
        for (int i = 0; i < num; i++) {
            out.add(deck.take());
        }
        return out;
    }
}
