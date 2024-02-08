package org.example.black_jack.view.player_data_view;

import org.example.black_jack.model.game.PlayerData;
import org.example.black_jack.model.game.PlayerStatus;
import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.table_view.TextTableView;

import java.util.List;
import java.util.function.Function;

public class TextPdataView extends AbstractTextPdataView {
    protected final TextTableView tableView;

    public TextPdataView(List<PlayerData> value, Printer printer,  Function<Card, String> cardMapper) {
        super(value, printer);
        List<org.example.common.model.deck.Deck> decks = decks(value);
        this.tableView = new TextTableView(decks, printer, cardMapper);
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
        tableView.show();
    }


    @Override
    protected void showOneStatus(PlayerStatus status, String textStatus) {
        printer.out(textStatus);
    }
}
