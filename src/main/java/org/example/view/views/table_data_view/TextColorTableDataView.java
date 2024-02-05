package org.example.view.views.table_data_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.PlayerData;
import org.example.model.game.PlayerStatus;
import org.example.view.views.printer.ColorPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TextColorTableDataView extends AbstractTableDataView<String> {
    private final static String TEMPLATE = "%-20s";
    private final static String POINT_TEMPLATE = "POINTS: %s";
    private final static String POINT_UNKNOWN = "???";
    private final static String LINE = "----";
    private final static ColorPrinter.Color NAME_COLOR = ColorPrinter.Color.YELLOW;
    private final static ColorPrinter.Color IN_GAME_COLOR = ColorPrinter.Color.BLUE;
    private final static ColorPrinter.Color BUST_COLOR = ColorPrinter.Color.DEFAULT;
    private final static ColorPrinter.Color WIN_COLOR = ColorPrinter.Color.GREEN;
    private final static ColorPrinter.Color BLACK_JACK_COLOR = WIN_COLOR;
    private final static ColorPrinter.Color LOSE_COLOR = BUST_COLOR;
    private final ColorPrinter colorPrinter;


    public TextColorTableDataView(ColorPrinter colorPrinter, Function<Card, String> map) {
        super(colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show(List<PlayerData> dataList) {
        int num = dataList.size();
        List<Deck> decks = decks(dataList);
        showNames(dataList);
        showLines(num);
        showDecks(decks);
        showLines(num);
        showPoints(dataList);
        showStatus(dataList);

    }

    private List<Deck> decks(List<PlayerData> dataList) {
        List<Deck> decks = new ArrayList<>();
        for (PlayerData data : dataList) {
            decks.add(data.getDeck());
        }
        return decks;
    }

    private void showNames(List<PlayerData> dataList) {
        for (PlayerData data : dataList) {
            String name = data.getPlayer().getName();
            String text = String.format(TEMPLATE, name);
            colorPrinter.colorOut(NAME_COLOR, text);
        }
        colorPrinter.output("");
    }

    private void showLines(int num) {
        for (int i = 0; i < num; i++) {
            String text = String.format(TEMPLATE, LINE);
            colorPrinter.out(text);
        }
        colorPrinter.output("");
    }

    private void showPoints(List<PlayerData> dataList) {
        for (PlayerData data : dataList) {
            String text = data.isCardsOpen() ? String.valueOf(data.getPoint()) : POINT_UNKNOWN;
            text = String.format(POINT_TEMPLATE, text);
            text = String.format(TEMPLATE, text);
            colorPrinter.out(text);
        }
        colorPrinter.output("");
    }

    private void showStatus(List<PlayerData> dataList) {
        for (PlayerData data : dataList) {
            PlayerStatus status = data.getStatus();
            ColorPrinter.Color color = color(status);
            String text = text(status);

            text = String.format(TEMPLATE, text);
            colorPrinter.colorOut(color, text);
        }
        colorPrinter.output("");
    }

    private void showDecks(List<Deck> decks) {
        int max = max(decks);
        for (int line = 0; line < max; line++) {
            for (Deck deck : decks) {
                List<Card> cards = deck.toList();

                String text = "";
                ColorPrinter.Color color = ColorPrinter.Color.DEFAULT;
                if (cards.size() > line) {
                    Card card = cards.get(line);
                    text = text(card);
                    color = color(card);
                }
                text = String.format(TEMPLATE, text);
                colorPrinter.colorOut(color, text);
            }
            colorPrinter.output("");
        }
    }

    private ColorPrinter.Color color(Card card) {
        if (!card.isOpen()) {
            return ColorPrinter.Color.DEFAULT;
        }
        switch (card.getSuit().getColor()) {
            case BLACK:
                return ColorPrinter.Color.GREEN;
            case RED:
                return ColorPrinter.Color.RED;
            default:
                return ColorPrinter.Color.DEFAULT;
        }
    }

    private ColorPrinter.Color color(PlayerStatus status) {

        switch (status) {
            case IN_GAME: return IN_GAME_COLOR;
            case BUST: return BUST_COLOR;
            case LOSE: return LOSE_COLOR;
            case WIN: return WIN_COLOR;
            case BLACK_JACK: return BLACK_JACK_COLOR;
            default: return ColorPrinter.Color.DEFAULT;
        }
    }


}
