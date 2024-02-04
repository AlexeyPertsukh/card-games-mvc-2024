package org.example.view.card_mapper;

import org.example.model.card.Card;

import java.util.function.Function;

public interface CardMapper<T> extends Function<Card, T> {
    T apply(Card card);
}
