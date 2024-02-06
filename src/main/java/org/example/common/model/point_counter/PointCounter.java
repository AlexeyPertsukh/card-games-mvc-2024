package org.example.common.model.point_counter;

import org.example.common.model.deck.Deck;

import java.util.function.Function;

public interface PointCounter extends Function<Deck, Integer> {
}
