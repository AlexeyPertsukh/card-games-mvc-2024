package org.example.common.view.views.card_view;

import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;

import java.util.function.Function;

public abstract class CardView<T> extends AbstractView<Card> {
    protected final Function<Card, T> map;

    public CardView(Card value, Printer printer, Function<Card, T> map) {
        super(value, printer);
        this.map = map;
    }
}
