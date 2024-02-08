package org.example.black_jack.view.player_data_view;

import org.example.black_jack.model.game.PlayerData;
import org.example.common.view.views.AbstractView;
import org.example.common.view.printer.Printer;

import java.util.List;

public abstract class PdataView extends AbstractView<List<PlayerData>> {
    public PdataView(List<PlayerData> value, Printer printer) {
        super(value, printer);
    }
}
