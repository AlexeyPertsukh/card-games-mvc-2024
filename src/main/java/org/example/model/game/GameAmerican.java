package org.example.model.game;

import org.example.model.Deck;
import org.example.model.Rules;
import org.example.model.card.Card;
import org.example.model.player.bot.Dealer;
import org.example.model.player.Player;
import org.example.model.point_counter.PointCounter;

import java.util.*;

public class GameAmerican implements Game {
    private static final boolean CARD_CLOSE = false;
    private static final boolean CARD_OPEN = true;
    private final Rules rules;
    private final PointCounter counter;
    private final Deck masterDeck;
    private final Dealer dealer;

    private final List<Player> players = new ArrayList<>();
    private final Map<Player, PlayerData> storage = new HashMap<>();


    public GameAmerican(Rules rules, PointCounter counter, Deck masterDeck, Dealer dealer, Player... players) {
        this.rules = rules;
        this.counter = counter;
        this.masterDeck = masterDeck;
        this.dealer = dealer;
        this.players.addAll(List.of(players));

        masterDeck.shuffle();

        for (Player player : players) {
            Deck deck = new Deck();
            PlayerData data = new PlayerData(player, deck);
            storage.put(player, data);
        }

        PlayerData dealerData = new PlayerData(dealer, new Deck());
        storage.put(dealer, dealerData);
    }


    @Override
    public Iterator<Player> playerIterator() {
        return new PlayerIterator();
    }

    @Override
    public Dealer dealer() {
        return dealer;
    }


    private PlayerData dealerData() {
        return storage.get(dealer());
    }

    @Override
    public Deck deck(Player player) {
        PlayerData data = storage.get(player);
        return data.getDeck();
    }

    @Override
    public PlayerStatus status(Player player) {
        PlayerData data = storage.get(player);
        return data.getStatus();
    }

    @Override
    public boolean isInGame(Player player) {
        PlayerData data = storage.get(player);
        return data.isInGame();
    }

    @Override
    public boolean isDeckOpen(Player player) {
        PlayerData data = storage.get(player);
        return data.getDeck().isOpen();
    }

    @Override
    public void openDeck(Player player) {
        PlayerData data = storage.get(player);
        data.getDeck().open();
    }

    @Override
    public List<PlayerData> tableData() {
        List<PlayerData> out = new ArrayList<>();
        for (Player player : players) {
            PlayerData data = storage.get(player);
            out.add(data);
        }
        out.add(dealerData());
        return out;
    }

    @Override
    public Card addOpenCard(Player player) {
        return addCard(player, CARD_OPEN);
    }

    @Override
    public Card addCloseCard(Player player) {
        return addCard(player, CARD_CLOSE);
    }

    @Override
    public List<Card> addOpenCard(Player player, int num) {
        return addCard(player, CARD_OPEN, num);
    }

    @Override
    public List<Card> addCloseCard(Player player, int num) {
        return addCard(player, CARD_CLOSE, num);
    }

    @Override
    public List<Card> beginAddPlayerCard(Player player) {
        return addOpenCard(player, 2);
    }

    @Override
    public List<Card> beginAddDealerCard() {
        List<Card> cards = new ArrayList<>();
        Card card = addOpenCard(dealer());
        cards.add(card);
        card = addCloseCard(dealer());
        cards.add(card);
        return cards;
    }

    private List<Card> addCard(Player player, boolean isOpen, int num) {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Card card = masterDeck.take();
            if (isOpen) {
                card.open();
            }
            cards.add(card);
            storage.get(player).getDeck().add(card);
        }
        updateData(player);
        return cards;
    }

    private Card addCard(Player player, boolean isOpen) {
        List<Card> cards = addCard(player, isOpen, 1);
        return cards.get(0);
    }

    private void updateData(Player player) {
        PlayerData data = storage.get(player);
        Deck deck = data.getDeck();
        int point = counter.apply(deck);
        data.setPoint(point);

        PlayerStatus status = PlayerStatus.IN_GAME;

        if (rules.isBust(point)) {
            status = PlayerStatus.BUST;
        } else if (rules.isBlackJack(deck.size(), point)) {
            status = PlayerStatus.BLACK_JACK;
        }

        data.setStatus(status);
    }

    private PlayerStatus statusWhenCalcResult(PlayerData data, int winPoint) {
        Deck deck = data.getDeck();
        int point = data.getPoint();
        if (rules.isBlackJack(deck.size(), point)) {
            return PlayerStatus.BLACK_JACK;
        }
        if (rules.isBust(point)) {
            return PlayerStatus.BUST;
        }
        if (rules.isLose(winPoint, point)) {
            return PlayerStatus.LOSE;
        }
        if (rules.isWin(winPoint, point)) {
            return PlayerStatus.WIN;
        }

        throw new IllegalArgumentException();
    }

    public class PlayerIterator implements Iterator<Player> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < players.size();
        }

        @Override
        public Player next() {
            return players.get(index++);
        }

    }

}
