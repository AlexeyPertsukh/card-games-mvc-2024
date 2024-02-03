package org.example.view.views.group_player_view;

import org.example.model.DeckStorage;
import org.example.model.card.Card;
import org.example.view.Printer;
import org.example.view.views.AbstractView;
import org.example.view.views.deck_view.DeckView;

import java.util.function.Function;

public abstract class DeckStorageView<T> extends AbstractView<DeckStorage> {
    protected final Function<Card, T> map;

    public DeckStorageView(Printer printer, Function<Card, T> map) {
        super(printer);
        this.map = map;
    }
}
