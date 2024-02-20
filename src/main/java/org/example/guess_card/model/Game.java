package org.example.guess_card.model;

import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {
    private final Deck deck;
    private final List<Player> players = new ArrayList<>();
    private PlayerIterator iterator;

    public Game(Deck deck, Player... players) {
        this.deck = deck;
        this.players.addAll(List.of(players));
        iterator = new PlayerIterator();
    }

    public Player currentPlayer() {
        return iterator.current();
    }

    public void switchPlayer() {
        iterator.next();
        if (!iterator.hasNext()) {
            iterator = new PlayerIterator();
        }
    }

    private class PlayerIterator implements Iterator<Player> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < players.size();
        }

        @Override
        public Player next() {
            return players.get(index++);
        }

        public Player current() {
            return players.get(index);
        }

    }
}
