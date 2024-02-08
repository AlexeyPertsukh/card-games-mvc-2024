package org.example.black_jack.model.game;

import org.example.black_jack.model.Rules;
import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.common.model.player.bot.Dealer;
import org.example.common.model.point_counter.PointCounter;

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
    private final DataUpdater updater;

    public GameAmerican(Rules rules, PointCounter counter, Deck masterDeck, Dealer dealer, Player... players) {
        this.rules = rules;
        this.counter = counter;
        this.masterDeck = masterDeck;
        this.dealer = dealer;
        this.players.addAll(List.of(players));

        masterDeck.shuffle();

        for (Player player : players) {
            org.example.common.model.deck.Deck deck = new org.example.common.model.deck.Deck();
            PlayerData data = new PlayerData(player, deck);
            storage.put(player, data);
        }

        PlayerData dealerData = new PlayerData(dealer, new org.example.common.model.deck.Deck());
        storage.put(dealer, dealerData);
        updater = new DataUpdater(rules, counter);
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
    public List<PlayerData> playerData() {
        List<PlayerData> out = new ArrayList<>();
        for (Player player : players) {
            PlayerData data = storage.get(player);
            out.add(data);
        }
        out.add(dealerData());
        return out;
    }

    @Override
    public Deck addOpenCard(Player player) {
        return addCard(player, CARD_OPEN);
    }

    @Override
    public Deck addCloseCard(Player player) {
        return addCard(player, CARD_CLOSE);
    }

    @Override
    public Deck addOpenCard(Player player, int num) {
        return addCard(player, CARD_OPEN, num);
    }

    @Override
    public Deck addCloseCard(Player player, int num) {
        return addCard(player, CARD_CLOSE, num);
    }

    @Override
    public void beginAddCard() {
        for (PlayerData data : storage.values()) {
            Player player = data.getPlayer();
            if (player == dealer) {
                continue;
            }
            addOpenCard(player, 2);
        }

        addOpenCard(dealer);
        addCloseCard(dealer);
    }

    private Deck addCard(Player player, boolean isOpen, int num) {

        Deck playerDeck = storage.get(player).getDeck();
        Deck second = masterDeck.take(num);
        if (isOpen) {
            second.open();
        }
        playerDeck.add(second);

        updateData(player);
        return second;
    }

    private Deck addCard(Player player, boolean isOpen) {
        return addCard(player, isOpen, 1);
    }

    private void updateData(Player player) {
        PlayerData data = storage.get(player);
        updater.updateOnWork(data);
    }

    @Override
    public void calculateResult() {
        List<PlayerData> list = new ArrayList<>(storage.values());
        int dealerPoint = storage.get(dealer).getPoint();
        updater.updateResult(list, dealerPoint);
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
