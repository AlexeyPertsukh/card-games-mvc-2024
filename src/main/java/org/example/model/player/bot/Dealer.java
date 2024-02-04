package org.example.model.player.bot;

import org.example.model.Deck;

import java.util.function.Function;

public class Dealer extends Bot {

    public Dealer(String name, Function<Deck, Integer> counter) {
        super(name, new DealerAi(), counter);
    }
}
