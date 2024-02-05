package org.example.view.views.player_data_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.PlayerData;
import org.example.model.player.Player;
import org.example.model.player.bot.Bot;
import org.example.view.views.printer.Printer;
import org.example.view.views.table_view.TableView;
import org.example.view.views.table_view.TextTableView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TextPdataView extends AbstractTextPdataView {
    protected final TextTableView tableView;

    public TextPdataView(Printer printer, Function<Card, String> cardMapper) {
        super(printer);
        tableView = new TextTableView(printer, cardMapper);
    }

    protected String template() {
        return tableView.template();
    }


    @Override
    protected void showName(List<PlayerData> data) {
        String template = template();
        for (PlayerData d : data) {
            String text = String.format(template, name(d.getPlayer()));
            printer.out(text);
        }
        printer.output();
    }

    private String name(Player player) {
        String text = player.getName();
        if (player instanceof Bot) {
            text += "[bot]";
        }
        return text;
    }

    @Override
    protected void showLine(int repeat) {
        for (int i = 0; i < repeat; i++) {
            String text = String.format(template(), LINE);
            printer.out(text);
        }
        printer.output();
    }

    @Override
    protected void showTable(List<PlayerData> data) {
        List<Deck> decks = decks(data);
        tableView.show(decks);
    }


    @Override
    protected void showPoint(List<PlayerData> data) {
        for (PlayerData d : data) {
            String text = text(d.getPoint(), d.isCardsOpen());
            text = String.format(template(), text);
            printer.out(text);
        }
        printer.output();
    }

    @Override
    protected void showStatus(List<PlayerData> data) {
    }
}
