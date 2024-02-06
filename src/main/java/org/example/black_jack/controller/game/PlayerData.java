package org.example.black_jack.controller.game;


import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.model.player.Player;

public class PlayerData {
    private final Player player;
    private final Deck deck;
    private PlayerStatus status = PlayerStatus.IN_GAME;
    private int point;

    public PlayerData(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isCardsOpen() {
        for (Card card : deck.toList()) {
            if(!card.isOpen()) {
                return false;
            }
        }
        return true;
    }

    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public boolean isInGame() {
        return status == PlayerStatus.IN_GAME;
    }

    public void setStatus(PlayerStatus status) {
//        if(this.state != PlayerState.IN_GAME) {
//            throw new IllegalArgumentException("the player is not in the game");
//        }
        this.status = status;
    }
}
