package org.example.view.views.table_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.view.views.AbstractView;
import org.example.view.printer.Printer;

import java.util.List;
import java.util.function.Function;

public abstract class TableView<T> extends AbstractView<List<Deck>> {
    protected final Function<Card, T> mapper;
    public TableView(Printer printer, Function<Card, T> mapper) {
        super(printer);
        this.mapper = mapper;
    }
}
