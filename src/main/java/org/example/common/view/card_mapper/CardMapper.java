package org.example.common.view.card_mapper;

import org.example.common.model.card.Card;

import java.util.function.Function;

public interface CardMapper<T> extends Function<Card, T> {
    T apply(Card deck);
}
