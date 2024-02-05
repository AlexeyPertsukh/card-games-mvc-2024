package org.example.view.views.player_data_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.PlayerData;
import org.example.view.views.printer.Printer;
import org.example.view.views.table_view.TableView;
import org.example.view.views.table_view.TextTableView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractTextPdataView extends PdataView<String> {
    protected static final String LINE = "------";
    protected static final String HIDDEN = "<hidden>";
    protected static final String POINT_TEMPLATE = "POINTS: %d";

    public AbstractTextPdataView(Printer printer) {
        super(printer);
    }

    @Override
    public void show(List<PlayerData> data) {
        int repeat = data.size();
        showName(data);
        showLine(repeat);
        showTable(data);
        showLine(repeat);
        showPoint(data);
        showStatus(data);
    }

    protected abstract void showName(List<PlayerData> data);
    protected abstract void showLine(int repeat);
    protected abstract void showTable(List<PlayerData> data);
    protected abstract void showPoint(List<PlayerData> data);
    protected abstract void showStatus(List<PlayerData> data);

    protected List<Deck> decks(List<PlayerData> data) {
        List<Deck> decks = new ArrayList<>();
        for (PlayerData d : data) {
            decks.add(d.getDeck());
        }
        return decks;
    }

    protected String text(int point, boolean isOpen){
        return isOpen ? String.format(POINT_TEMPLATE, point) : HIDDEN;
    }

}
