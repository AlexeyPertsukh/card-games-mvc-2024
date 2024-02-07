package org.example.common.model.deck_factory;

import org.example.common.model.deck.Deck;

import java.util.function.Supplier;

public interface DeckFactory extends Supplier<Deck> {
    @Override
    Deck get();
    Deck shoes(int num);
    Deck getRandom(int num);

}
