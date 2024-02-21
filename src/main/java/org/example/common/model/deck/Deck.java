package org.example.common.model.deck;

import org.example.common.model.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {
    private final List<Card> decks = new ArrayList<>();

    public Deck() {
    }

    public Deck(Card card) {
        this.decks.add(card);
    }

    public Deck(List<Card> decks) {
        this.decks.addAll(decks);
    }

    public Card get(int index) {
        return decks.get(index);
    }


    public Card take() {
        return decks.remove(decks.size() - 1);
    }

    public Deck take(int num) {
        Deck deck = new Deck();
        for (int i = 0; i < num; i++) {
            deck.add(take());
        }
        return deck;
    }


    public List<Card> toList() {
        return new ArrayList<>(decks);
    }

    public void add(Card deck) {
        decks.add(deck);
    }
    public void add(List<Card> list) {
        decks.addAll(list);
    }
    public void add(Deck deck) {
        add(deck.toList());
    }


    public int size() {
        return decks.size();
    }

    public void shuffle() {
        Collections.shuffle(decks);
    }

    public boolean isOpen() {
        for (Card deck : decks) {
            if (!deck.isOpen()) {
                return false;
            }
        }
        return true;
    }

    public void open() {
        for (Card deck : decks) {
            deck.open();
        }
    }

    public void sort(Comparator<Card> c) {
        decks.sort(c);
    }
}
