package org.example.guess_card.model.storage;

import org.example.common.model.player.Player;

import java.util.*;

public abstract class AbstractStorage<D> implements Storage<D> {
    protected final Map<Player, D> map = new HashMap<>();
    private final List<Player> players = new LinkedList<>();
    @Override
    public void put(Player player, D data) {
        map.put(player, data);
        players.remove(player);
        players.add(player);
    }

    @Override
    public void put(Player player) {
        put(player, defaultData(player));
    }

    protected abstract D defaultData(Player player);

    @Override
    public D get(Player player) {
        return map.get(player);
    }

    @Override
    public boolean contains(Player player) {
        return map.containsKey(player);
    }

    @Override
    public List<D> values() {

        List<D> out = new ArrayList<>();
        for (Player player : players) {
            D data = map.get(player);
            out.add(data);
        }

        return out;
    }

}
