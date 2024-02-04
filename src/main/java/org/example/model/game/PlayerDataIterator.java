package org.example.model.game;

import java.util.Iterator;
import java.util.List;

public class PlayerDataIterator implements Iterator<PlayerData> {
    private final List<PlayerData> playerDataList;
    private int index;

    public PlayerDataIterator(List<PlayerData> playerDataList) {
        this.playerDataList = playerDataList;
    }

    @Override
    public boolean hasNext() {
        return index < playerDataList.size();
    }

    @Override
    public PlayerData next() {
        return playerDataList.get(index++);
    }

    public int getIndex() {
        return index;
    }
}
