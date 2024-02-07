package org.example.common.model.deck;

import org.example.common.model.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
    }

    public Deck(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public Card get(int index) {
        return cards.get(index);
    }


    public Card take() {
        return cards.remove(cards.size() - 1);
    }

    public Deck take(int num) {
        Deck deck = new Deck();
        for (int i = 0; i < num; i++) {
            deck.add(take());
        }
        return deck;
    }


    public List<Card> toList() {
        return new ArrayList<>(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }
    public void add(List<Card> list) {
        cards.addAll(list);
    }
    public void add(Deck deck) {
        add(deck.toList());
    }


    public int size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean isOpen() {
        for (Card card : cards) {
            if (!card.isOpen()) {
                return false;
            }
        }
        return true;
    }

    public void open() {
        for (Card card : cards) {
            card.open();
        }
    }
}
