package org.example.view.views.player_data_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.PlayerData;
import org.example.model.game.PlayerStatus;
import org.example.view.printer.Printer;
import org.example.view.views.table_view.TextTableView;

import java.util.List;
import java.util.function.Function;

public class TextPdataView extends AbstractTextPdataView {
    protected final TextTableView tableView;

    public TextPdataView(Printer printer, Function<Card, String> cardMapper) {
        super(printer);
        tableView = new TextTableView(printer, cardMapper);
    }

    @Override
    protected void showOneName(String name) {
        printer.out(name);
    }

    @Override
    protected void showOneLine(String line) {
        printer.out(line);
    }

    @Override
    protected String template() {
        return tableView.template();
    }




    @Override
    protected void showOnePoint(String textPoint) {
        printer.out(textPoint);
    }

    @Override
    protected void showTable(List<PlayerData> data) {
        List<Deck> decks = decks(data);
        tableView.show(decks);
    }


    @Override
    protected void showOneStatus(PlayerStatus status, String textStatus) {
        printer.out(textStatus);
    }
}
