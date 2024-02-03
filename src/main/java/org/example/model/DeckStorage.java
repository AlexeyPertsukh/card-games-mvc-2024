package org.example.model;

import org.example.view.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeckStorage {
    private final Map<Player, Deck> storage = new HashMap<>();

    public DeckStorage() {
    }

    public void put(Player player, Deck deck) {
        storage.put(player, deck);
    }

    public Deck get(Player player) {
        return storage.get(player);
    }

    public List<Player> players() {
        return new ArrayList<>(storage.keySet());
    }

    public List<Deck> decks() {
        return new ArrayList<>(storage.values());
    }

    public int size() {
        return storage.size();
    }


}
