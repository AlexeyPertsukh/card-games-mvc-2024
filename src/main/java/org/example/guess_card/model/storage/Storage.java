package org.example.guess_card.model.storage;

import org.example.common.model.player.Player;

import java.util.List;

public interface Storage<D> {
    void put(Player player, D data);
    void put(Player player);
    D get(Player player);
    boolean contains(Player player);

    List<D> values();

}
