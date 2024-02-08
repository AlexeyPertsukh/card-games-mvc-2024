package org.example.black_jack.model.game;

import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.common.model.player.bot.Dealer;

import java.util.Iterator;
import java.util.List;

public interface Game {
    Iterator<Player> playerIterator();

    Dealer dealer();

    Deck deck(Player player);
    PlayerStatus status(Player player);
    boolean isInGame(Player player);

    boolean isDeckOpen(Player player);
    void openDeck(Player player);

    List<PlayerData> playerData();

    Deck addOpenCard(Player player);
    Deck addOpenCard(Player player, int num);

    Deck addCloseCard(Player player);
    Deck addCloseCard(Player player, int num);

    void beginAddCard();

    void calculateResult();
}
