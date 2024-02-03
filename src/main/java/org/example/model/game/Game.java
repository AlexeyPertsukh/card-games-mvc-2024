package org.example.model.game;

import org.example.model.Deck;
import org.example.model.Rules;
import org.example.model.card.Card;
import org.example.model.player.Player;
import org.example.model.point_counter.PointCounter;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final boolean CARD_CLOSE = false;
    private static final boolean CARD_OPEN = true;
    private final Rules rules;
    private final PointCounter counter;
    private final Deck masterDeck;
    private final Player[] players;

    private int indexCurrentPlayer;

    private PlayerData current;
    private final List<PlayerData> playerDataList = new ArrayList<>();

    public Game(Rules rules, PointCounter counter, Deck masterDeck, Player... players) {
        this.rules = rules;
        this.counter = counter;
        this.masterDeck = masterDeck;
        this.players = players;

        masterDeck.shuffle();

        for (Player player : players) {
            Deck deck = new Deck();
            PlayerData data = new PlayerData(player, deck);
            playerDataList.add(data);
        }


    }

    public int getIndexCurrentPlayer() {
        return indexCurrentPlayer;
    }

    public PlayerData get(int index) {
        return playerDataList.get(index);
    }

    public PointCounter getCounter() {
        return counter;
    }

    public boolean hasNextPlayer() {
        return playerDataList.size() > indexCurrentPlayer;
    }

    public List<PlayerData> getPlayerDataList() {
        return playerDataList;
    }

    public void next() {
        indexCurrentPlayer++;
    }

    public int numberPlayers() {
        return playerDataList.size();
    }

    public void updateData(int index) {
        PlayerData data = get(index);
        updateData(data);
    }

    private void updateData(PlayerData data) {
        Deck deckOnlyOpenCard = deckOnlyOpenCard(data.getDeck());
        int point = counter.count(deckOnlyOpenCard);
        data.setPoint(point);
        PlayerState state = stateWhenGameRunning(data);
        data.setState(state);
    }



    public void updateResultData() {
        List<Integer> points = new ArrayList<>();

        for (PlayerData data : playerDataList) {
            Deck deck = data.getDeck();
            int point = counter.count(deck);
            data.setPoint(point);
            points.add(point);
        }

        int winPoint = rules.winPoint(points);

        for (PlayerData data : playerDataList) {
            PlayerState state = stateWhenCalcResult(data, winPoint);
            data.setState(state);
        }
    }

    public List<Card> giveBeginCardToPlayer(int index) {
        return giveOpenCard(index, 2);
    }

    public List<Card> giveBeginCardToDealer(int index) {
        List<Card> cards = new ArrayList<>();
        List<Card> first = giveOpenCard(index, 1);
        List<Card> second = giveCloseCard(index, 1);
        cards.addAll(first);
        cards.addAll(second);
        return cards;
    }

    public List<Card> giveOpenCardToCurrent() {
        return giveOpenCard(indexCurrentPlayer, 1);
    }

    public List<Card> giveOpenCard(int index, int num) {
        PlayerData data = playerDataList.get(index);
        return giveCard(data, num, CARD_OPEN);
    }

    public List<Card> giveOpenCard(int index) {
        return giveOpenCard(index, 1);
    }

    public List<Card> giveCloseCard(int index, int num) {
        PlayerData data = playerDataList.get(index);
        return giveCard(data, num, CARD_CLOSE);
    }


    private List<Card> giveCard(PlayerData data, int num, boolean isOpen) {
        List<Card> cards = new ArrayList<>();
        Deck deck = data.getDeck();
        for (int i = 0; i < num; i++) {
            Card card = masterDeck.take();
            if (isOpen) {
                card.open();
            }
            deck.add(card);
            cards.add(card);
        }
        return cards;
    }


    private Deck deckOnlyOpenCard(Deck deck) {
        List<Card> cards = deck.toList();
        Deck out = new Deck();

        for (Card card : cards) {
            if (card.isOpen()) {
                out.add(card);
            }
        }
        return out;
    }

    private PlayerState stateWhenGameRunning(PlayerData data) {
        Deck deck = data.getDeck();
        int point = data.getPoint();
        if (rules.isBust(point)) {
            return PlayerState.BUST;
        }

        if (rules.isBlackJack(deck.size(), point)) {
            return PlayerState.BLACK_JACK;
        }

        return PlayerState.IN_GAME;
    }

    private PlayerState stateWhenCalcResult(PlayerData data, int winPoint) {
        Deck deck = data.getDeck();
        int point = data.getPoint();
        if (rules.isBlackJack(deck.size(), point)) {
            return PlayerState.BLACK_JACK;
        }
        if (rules.isBust(point)) {
            return PlayerState.BUST;
        }
        if (rules.isLose(winPoint, point)) {
            return PlayerState.LOSE;
        }
        if (rules.isWin(winPoint, point)) {
            return PlayerState.WIN;
        }

        throw new IllegalArgumentException();
    }


}
