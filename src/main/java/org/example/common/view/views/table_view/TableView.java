package org.example.common.view.views.table_view;

import org.example.common.view.views.AbstractView;
import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;

import java.util.List;
import java.util.function.Function;

public abstract class TableView<T> extends AbstractView<List<org.example.common.model.deck.Deck>> {
    protected final Function<Card, T> mapper;

    public TableView(List<org.example.common.model.deck.Deck> value, Printer printer, Function<Card, T> mapper) {
        super(value, printer);
        this.mapper = mapper;
    }
}
