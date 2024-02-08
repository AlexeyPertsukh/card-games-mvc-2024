package org.example.common.view.views.deck_view;

import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;

import java.util.function.Function;

public abstract class DeckView<T> extends AbstractView<org.example.common.model.deck.Deck> {
    protected final Function<Card, T> map;

    public DeckView(org.example.common.model.deck.Deck value, Printer printer, Function<Card, T> map) {
        super(value, printer);
        this.map = map;
    }
}
