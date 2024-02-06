package org.example.view.views.deck_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.view.printer.Printer;
import org.example.view.views.AbstractView;

import java.util.function.Function;

public abstract class DeckView<T> extends AbstractView<Deck> {
    protected final Function<Card, T> map;
    public DeckView(Printer printer, Function<Card, T> map) {
        super(printer);
        this.map = map;
    }
}
