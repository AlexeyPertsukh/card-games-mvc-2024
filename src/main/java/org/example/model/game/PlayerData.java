package org.example.model.game;


import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.player.Player;

public class PlayerData {
    private final Player player;
    private final Deck deck;
    private PlayerState state = PlayerState.IN_GAME;
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

    public PlayerState getState() {
        return state;
    }

    public boolean isInGame() {
        return state == PlayerState.IN_GAME;
    }

    public void setState(PlayerState state) {
//        if(this.state != PlayerState.IN_GAME) {
//            throw new IllegalArgumentException("the player is not in the game");
//        }
        this.state = state;
    }
}
