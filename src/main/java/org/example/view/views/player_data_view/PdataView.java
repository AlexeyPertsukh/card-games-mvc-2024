package org.example.view.views.player_data_view;

import org.example.model.card.Card;
import org.example.model.game.PlayerData;
import org.example.view.views.AbstractView;
import org.example.view.views.printer.Printer;

import java.util.List;
import java.util.function.Function;

public abstract class PdataView<T> extends AbstractView<List<PlayerData>> {
    public PdataView(Printer printer) {
        super(printer);
    }
}
