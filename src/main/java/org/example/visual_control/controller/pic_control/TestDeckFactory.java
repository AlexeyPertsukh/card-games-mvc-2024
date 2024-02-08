package org.example.visual_control.controller.pic_control;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.card.CardSuit;

import java.util.ArrayList;
import java.util.List;

public class TestDeckFactory {
    private TestDeckFactory() {
    }

    public static List<org.example.common.model.deck.Deck> get() {
        List<org.example.common.model.deck.Deck> list = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            if (suit.isNone()) {
                continue;
            }
            org.example.common.model.deck.Deck deck = deck(suit);
            list.add(deck);
        }
        list.add(deckMore());
        return list;
    }

    public static org.example.common.model.deck.Deck deck(CardSuit suit) {
        org.example.common.model.deck.Deck deck = new org.example.common.model.deck.Deck();
        for (CardRank rank : CardRank.values()) {
            if (rank == CardRank.JOKER) {
                continue;
            }
            Card card = new Card(rank, suit);
            card.open();
            deck.add(card);
        }
        return deck;
    }

    public static org.example.common.model.deck.Deck deckMore() {
        org.example.common.model.deck.Deck deck = new org.example.common.model.deck.Deck();

        Card card = new Card(CardRank.JOKER, CardSuit.NONE_BLACK);
        deck.add(card);

        card = new Card(CardRank.JOKER, CardSuit.NONE_BLACK);
        card.open();
        deck.add(card);

        card = new Card(CardRank.JOKER, CardSuit.NONE_RED);
        card.open();
        deck.add(card);

        return deck;
    }
}
