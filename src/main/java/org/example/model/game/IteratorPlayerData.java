package org.example.model.game;

import java.util.Iterator;
import java.util.List;

public class IteratorPlayerData implements Iterator<PlayerData> {
    private final List<PlayerData> playerDataList;
    private int position;

    public IteratorPlayerData(List<PlayerData> playerDataList) {
        this.playerDataList = playerDataList;
    }

    @Override
    public boolean hasNext() {
        return position < playerDataList.size();
    }

    @Override
    public PlayerData next() {
        return playerDataList.get(position++);
    }
}
