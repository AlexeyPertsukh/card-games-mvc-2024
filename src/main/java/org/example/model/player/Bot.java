package org.example.model.player;

import org.example.model.Deck;
import org.example.model.player.ai.Ai;

import java.util.function.Function;

public class Bot<T> extends Player{
    private final Ai ai;
    private final T take;
    private final T skip;

    public Bot(String name, Ai ai, T take, T skip) {
        super(name);
        this.ai = ai;
        this.take = take;
        this.skip = skip;
    }

    public T getTake() {
        return take;
    }

    public T getSkip() {
        return skip;
    }

    public T input(Deck deck, Function<Deck, Integer> counter) {
        int point = counter.apply(deck);
        Ai.Cmd cmd = ai.input(point);
        switch (cmd) {
            case TAKE: return take;
            case SKIP: return skip;
            default: throw new IllegalArgumentException("illegal ai command: " + cmd);
        }

    }
}
