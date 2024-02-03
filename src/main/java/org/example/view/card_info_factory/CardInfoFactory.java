package org.example.view.card_info_factory;

import org.example.model.card.Card;

public interface CardInfoFactory<T> {
    T create(Card card);
}
