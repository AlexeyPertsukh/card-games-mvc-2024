package org.example.guess_card.model;

import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.guess_card.model.bet.Bet;

import java.util.*;

public class Game {
    private final Deck deck;
    private final List<Player> players = new ArrayList<>();
    private PlayerIterator iterator;
    private final GcStorage storage = new GcStorage();
    private final PointCounter counter = new PointCounter();
    private final Map<Player, Bet> bets = new HashMap<>();

    public Game(Deck deck, Player... players) {
        this.deck = deck;
        this.players.addAll(List.of(players));
        iterator = new PlayerIterator();

        for (Player player : players) {
            storage.put(player);
        }

        this.deck.shuffle();

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

    public void addBetCurrentPlayer(Bet bet) {
        bets.put(currentPlayer(), bet);
    }

    public Card currentPlayerTakeCard() {
        Player player = currentPlayer();
        Card card = deck.take();
        card.open();
        Bet bet = bets.get(player);
        int point = counter.count(card, bet);
        storage.get(player).addPoint(point);

        return card;
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
