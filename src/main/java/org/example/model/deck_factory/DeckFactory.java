package org.example.model.deck_factory;

import org.example.model.Deck;

import java.util.function.Supplier;

public interface DeckFactory extends Supplier<Deck> {
    @Override
    Deck get();
}
