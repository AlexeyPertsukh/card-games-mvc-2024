package org.example.black_jack.model.game;


import org.example.common.model.card.Card;
import org.example.common.model.player.Player;

public class PlayerData {
    private final Player player;
    private final org.example.common.model.deck.Deck deck;
    private PlayerStatus status = PlayerStatus.IN_GAME;
    private int point;

    public PlayerData(Player player, org.example.common.model.deck.Deck deck) {
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
        for (Card deck : this.deck.toList()) {
            if(!deck.isOpen()) {
                return false;
            }
        }
        return true;
    }

    public Player getPlayer() {
        return player;
    }

    public org.example.common.model.deck.Deck getDeck() {
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
