package org.example.model.player;

import org.example.model.player.ai.Ai;
import org.example.model.player.ai.DealerAi;

public class Dealer<T> extends Bot<T>{
    public Dealer(String name) {
        super(name, new DealerAi());
    }
}
