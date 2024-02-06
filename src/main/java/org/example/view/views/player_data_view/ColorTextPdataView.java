package org.example.view.views.player_data_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.card.CardSuit;
import org.example.model.game.PlayerData;
import org.example.model.game.PlayerStatus;
import org.example.model.player.Player;
import org.example.model.player.bot.Bot;
import org.example.view.views.color_mapper.SuitToPrintColorMapper;
import org.example.view.views.printer.ColorPrinter;
import org.example.view.views.table_view.ColorTextTableView;

import java.util.List;
import java.util.function.Function;

public class ColorTextPdataView extends AbstractTextPdataView {
    private static final ColorPrinter.Color COLOR_DEFAULT = ColorPrinter.Color.DEFAULT;
    private static final ColorPrinter.Color COLOR_NAME = ColorPrinter.Color.YELLOW;
    private static final ColorPrinter.Color COLOR_POINT = COLOR_DEFAULT;
    private static final ColorPrinter.Color COLOR_LINE = COLOR_DEFAULT;
    private static final ColorPrinter.Color COLOR_STATUS_IN_GAME = ColorPrinter.Color.CYAN;
    private static final ColorPrinter.Color COLOR_STATUS_WIN = ColorPrinter.Color.GREEN;
    private static final ColorPrinter.Color COLOR_STATUS_BJ = COLOR_STATUS_WIN;
    protected final ColorPrinter colorPrinter;
    protected final ColorTextTableView colorTableView;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorMapper = new SuitToPrintColorMapper();

    public ColorTextPdataView(ColorPrinter colorPrinter, Function<Card, String> cardMapper) {
        super(colorPrinter);
        this.colorPrinter = colorPrinter;
        colorTableView = new ColorTextTableView(colorPrinter, cardMapper);
    }

    @Override
    protected void showOneName(String name) {
        colorPrinter.colorOut(COLOR_NAME, name);
    }

    @Override
    protected void showOneLine(String line) {
        colorPrinter.colorOut(COLOR_LINE, line);
    }

    protected String template() {
        return colorTableView.template();
    }

    @Override
    protected void showTable(List<PlayerData> data) {
        List<Deck> decks = decks(data);
        colorTableView.show(decks);
    }

    @Override
    protected void showOnePoint(String textPoint) {
        colorPrinter.colorOut(COLOR_POINT, textPoint);
    }

    @Override
    protected void showOneStatus(PlayerStatus status, String textStatus) {
        ColorPrinter.Color color = color(status);
        colorPrinter.colorOut(color, textStatus);
    }

    private ColorPrinter.Color color(PlayerStatus status) {
        switch (status) {
            case IN_GAME: return COLOR_STATUS_IN_GAME;
            case WIN: return COLOR_STATUS_WIN;
            case BLACK_JACK: return COLOR_STATUS_BJ;
            default: return COLOR_DEFAULT;
        }
    }

}
