package org.example.common.model.player.bot;

import org.example.common.model.deck.Deck;

import java.util.function.Function;

public class Dealer extends Bot {

    public Dealer(String name, Function<Deck, Integer> counter) {
        super(name, new DealerAi(), counter);
    }
}
