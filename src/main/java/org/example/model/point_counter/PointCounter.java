package org.example.model.point_counter;

import org.example.model.Deck;

import java.util.function.Function;

public interface PointCounter extends Function<Deck, Integer> {
}
