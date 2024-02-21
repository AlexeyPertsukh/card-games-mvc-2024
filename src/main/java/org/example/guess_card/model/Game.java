package org.example.guess_card.model;

import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.guess_card.model.bet.Bet;
import org.example.guess_card.model.rules.Rules;
import org.example.guess_card.model.storage.GcStorage;

import java.util.*;

public class Game {
    private final Rules rules;
    private final Deck deck;
    private final List<Player> players = new ArrayList<>();
    private PlayerIterator iterator;
    private final GcStorage storage = new GcStorage();
    private final PointCounter counter = new PointCounter();
    private final Map<Player, Bet> bets = new HashMap<>();

    public Game(Rules rules, Deck deck, Player... players) {
        this.rules = rules;
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

    public List<GcStorage.Data> dataValues() {
        return storage.values();
    }
    public GcStorage.Data currentPlayerData() {
        return storage.get(currentPlayer());
    }

    public void addBetCurrentPlayer(Bet bet) {
        bets.put(currentPlayer(), bet);
    }

    public TakeCardResult currentPlayerTakeCard() {
        Player player = currentPlayer();
        Card card = deck.take();
        card.open();
        Bet bet = bets.get(player);
        int point = counter.count(card, bet);
        storage.get(player).addPoint(point);

        return new TakeCardResult(card, point);
    }

    public boolean isCurrentPlayerWin() {
        int point = storage.get(currentPlayer()).getPoint();
        return rules.isWin(point);
    }

    public Rules getRules() {
        return rules;
    }

    public PointCounter getCounter() {
        return counter;
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

    public static class TakeCardResult {
        public final Card card;
        public final int addPoint;

        public TakeCardResult(Card card, int addPoint) {
            this.card = card;
            this.addPoint = addPoint;
        }
    }
}
