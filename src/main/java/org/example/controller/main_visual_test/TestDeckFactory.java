package org.example.controller.main_visual_test;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.card.CardRank;
import org.example.model.card.CardSuit;

import java.util.ArrayList;
import java.util.List;

public class TestDeckFactory {
    private TestDeckFactory() {
    }

    public static List<Deck> get() {
        List<Deck> list = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            if (suit.isNone()) {
                continue;
            }
            Deck deck = deck(suit);
            list.add(deck);
        }
        list.add(deckMore());
        return list;
    }

    public static Deck deck(CardSuit suit) {
        Deck deck = new Deck();
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

    public static Deck deckMore() {
        Deck deck = new Deck();

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
