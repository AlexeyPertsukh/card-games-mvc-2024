package org.example.model.result;

import org.example.view.Player;

public class Result {
    private final Player player;
    private final int point;
    private final State state;

    public Result(Player player, int point, State state) {
        this.player = player;
        this.point = point;
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPoint() {
        return point;
    }

    public State getState() {
        return state;
    }

    public enum State {
        LOSE,
        WIN,
        BUST
    }
}
