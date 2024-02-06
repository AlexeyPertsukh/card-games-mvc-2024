package org.example.common.model.player.bot;

import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;

import java.util.function.Function;

public class Bot extends Player {
    private final Ai ai;
    private final Function<Deck, Integer> counter;

    public Bot(String name, Ai ai, Function<Deck, Integer> counter) {
        super(name);
        this.ai = ai;
        this.counter = counter;
    }


    public BotCommand input(Deck deck) {
        int point = counter.apply(deck);
        return ai.input(point);
    }
    public enum BotCommand {
        TAKE,
        SKIP;
    }
}
