package org.example.guess_card.model.bet;

import java.util.function.Supplier;

public interface Bet extends Supplier<Object> {
    @Override
    Object get();
}
