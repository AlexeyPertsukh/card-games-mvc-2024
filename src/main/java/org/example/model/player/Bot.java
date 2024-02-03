package org.example.model.player;

import org.example.model.Deck;
import org.example.model.player.ai.Ai;

import java.util.function.Function;

public class Bot<T> extends Player{
    private final Ai ai;

    public Bot(String name, Ai ai) {
        super(name);
        this.ai = ai;
    }


    public T input(Deck deck, T take, T skip, Function<Deck, Integer> counter) {
        int point = counter.apply(deck);
        Ai.Cmd cmd = ai.input(point);
        switch (cmd) {
            case TAKE: return take;
            case SKIP: return skip;
            default: throw new IllegalArgumentException("illegal ai command: " + cmd);
        }

    }
}
