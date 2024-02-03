package org.example.model.deck_factory;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.card.CardRank;
import org.example.model.card.CardSuit;

public class DeckFactory54Card implements DeckFactory{
    private static DeckFactory54Card factory;
    private DeckFactory54Card() {
    }

    public static DeckFactory54Card getInstance() {
        if(factory == null) {
            factory = new DeckFactory54Card();
        }
        return factory;
    }

    @Override
    public Deck create() {
        Deck deck = new Deck();
        int indexRankTwo = CardRank.TWO.ordinal();
        CardRank[] ranks = CardRank.values();
        CardSuit[] suits = CardSuit.values();

        for (int i = indexRankTwo; i < ranks.length; i++) {
            for (CardSuit suit : suits) {
                Card card = new Card(ranks[i], suit);
                deck.add(card);
            }
        }
        return deck;
    }
}
