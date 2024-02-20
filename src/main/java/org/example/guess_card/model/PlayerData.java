package org.example.guess_card.model;

import org.example.common.model.player.Player;

public class PlayerData {
    private final Player player;
    private int point;

    public PlayerData(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPoint() {
        return point;
    }

    public void addPoint(int value) {
        point+= value;
    }
}
