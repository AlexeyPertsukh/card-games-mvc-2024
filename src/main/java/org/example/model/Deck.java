package org.example.model;

import org.example.model.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
    }

    public Card take() {
        return cards.remove(cards.size() - 1);
    }

    public List<Card> toList() {
        return new ArrayList<>(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void sort() {
    }

    public boolean isOpen() {
        for (Card card :                cards) {
            if(!card.isOpen()) {
                return false;
            }
        }
        return true;
    }

}
