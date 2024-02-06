package org.example.common.view.views.deck_view;

import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;

import java.util.function.Function;

public abstract class DeckView<T> extends AbstractView<Deck> {
    protected final Function<Card, T> map;

    public DeckView(Deck value, Printer printer, Function<Card, T> map) {
        super(value, printer);
        this.map = map;
    }
}
