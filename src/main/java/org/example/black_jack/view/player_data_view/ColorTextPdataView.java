package org.example.black_jack.view.player_data_view;

import org.example.black_jack.model.game.PlayerData;
import org.example.black_jack.model.game.PlayerStatus;
import org.example.common.model.card.Card;
import org.example.common.model.card.CardSuit;
import org.example.common.view.views.color_mapper.SuitToPrintColorMapper;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.table_view.ColorTextTableView;

import java.util.List;
import java.util.function.Function;

public class ColorTextPdataView extends AbstractTextPdataView {
    private static final ColorPrinter.Color COLOR_DEFAULT = ColorPrinter.Color.DEFAULT;
    private static final ColorPrinter.Color COLOR_NAME = ColorPrinter.Color.YELLOW;
    private static final ColorPrinter.Color COLOR_POINT = COLOR_DEFAULT;
    private static final ColorPrinter.Color COLOR_LINE = COLOR_DEFAULT;
    protected final ColorPrinter colorPrinter;
    protected final ColorTextTableView colorTableView;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorMapper = new SuitToPrintColorMapper();

    public ColorTextPdataView(List<PlayerData> value, ColorPrinter colorPrinter, Function<Card, String> cardMapper) {
        super(value, colorPrinter);
        this.colorPrinter = colorPrinter;
        List<org.example.common.model.deck.Deck> decks = decks(value);
        colorTableView = new ColorTextTableView(decks, colorPrinter, cardMapper);
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
        colorTableView.show();
    }

    @Override
    protected void showOnePoint(String textPoint) {
        colorPrinter.colorOut(COLOR_POINT, textPoint);
    }

    @Override
    protected void showOneStatus(PlayerStatus status, String textStatus) {
        ColorPrinter.Color color = ColorMap.get(status);
        colorPrinter.colorOut(color, textStatus);
    }

    enum ColorMap {
        IN_GAME(PlayerStatus.IN_GAME, ColorPrinter.Color.CYAN),
        WIN(PlayerStatus.WIN, ColorPrinter.Color.GREEN),
        LOSE(PlayerStatus.LOSE, ColorPrinter.Color.RED),
        BUST(PlayerStatus.BUST, ColorPrinter.Color.RED),
        PUSH(PlayerStatus.PUSH, ColorPrinter.Color.YELLOW),
        BLACK_JACK(PlayerStatus.BLACK_JACK, ColorPrinter.Color.GREEN),
        ;
        private final PlayerStatus status;
        private final ColorPrinter.Color color;

        ColorMap(PlayerStatus status, ColorPrinter.Color color) {
            this.status = status;
            this.color = color;
        }

        public static ColorPrinter.Color get(PlayerStatus status) {
            for (ColorMap map : values()) {
                if(map.status == status) {
                    return map.color;
                }
            }
            throw new IllegalArgumentException("illegal status to covert in printer color: " + status);
        }
    }

}
