package org.example.view.views.card_view;

import org.example.model.card.Card;
import org.example.view.printer.Printer;
import org.example.view.views.AbstractView;

import java.util.function.Function;

public abstract class CardView<T> extends AbstractView<Card> {
    protected final Function<Card, T> map;

    public CardView(Printer printer, Function<Card, T> map) {
        super(printer);
        this.map = map;
    }
}
