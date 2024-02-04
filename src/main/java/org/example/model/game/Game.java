package org.example.model.game;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.player.bot.Dealer;
import org.example.model.player.Player;

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

    List<PlayerData> tableData();

    Card addOpenCard(Player player);
    List<Card> addOpenCard(Player player, int num);

    Card addCloseCard(Player player);
    List<Card> addCloseCard(Player player, int num);

    List<Card> beginAddPlayerCard(Player player);
    List<Card> beginAddDealerCard();

}
