package org.example.view.views.group_player_data_view;

import org.example.model.card.Card;
import org.example.model.game.PlayerData;
import org.example.view.Printer;
import org.example.view.views.AbstractView;

import java.util.List;
import java.util.function.Function;

public abstract class ListPlayerDataView<T> extends AbstractView<List<PlayerData>> {
    protected final Function<Card, T> map;

    public ListPlayerDataView(Printer printer, Function<Card, T> map) {
        super(printer);
        this.map = map;
    }
}
