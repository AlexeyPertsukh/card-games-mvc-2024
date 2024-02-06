package org.example.view.views.player_data_view;

import org.example.model.Deck;
import org.example.model.game.PlayerData;
import org.example.model.player.Player;
import org.example.model.player.bot.Bot;
import org.example.view.views.printer.Printer;

import java.util.ArrayList;
import java.util.List;

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
        showOneStatus(data);
    }

    private void showName(List<PlayerData> data) {
        String template = template();
        for (PlayerData d : data) {
            String text = String.format(template, name(d.getPlayer()));
            showOneName(text);
        }
        printer.output();
    }

    private void showPoint(List<PlayerData> data) {
        for (PlayerData d : data) {
            String text = text(d.getPoint(), d.isCardsOpen());
            text = String.format(template(), text);
            showOnePoint(text);
        }
        printer.output();
    }

    private void showLine(int repeat) {
        for (int i = 0; i < repeat; i++) {
            String text = String.format(template(), LINE);
            showOneLine(text);
        }
        printer.output();
    }

    protected String name(Player player) {
        String text = player.getName();
        if (player instanceof Bot) {
            text += "[bot]";
        }
        return text;
    }
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

    protected abstract void showOneName(String name);
    protected abstract void showOneLine(String line);
    protected abstract void showOnePoint(String textPoint);
    protected abstract String template();
    protected abstract void showTable(List<PlayerData> data);
    protected abstract void showOneStatus(List<PlayerData> data);
}
