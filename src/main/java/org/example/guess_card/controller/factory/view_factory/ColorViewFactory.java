package org.example.guess_card.controller.factory.view_factory;

import org.example.common.model.card.Card;
import org.example.common.view.info_view.ColorInfoView;
import org.example.common.view.info_view.ColorMemoInfoView;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.info_view.MemoInfoView;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorConsolePrinter;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.View;
import org.example.common.view.views.deck_view.ColorPicDeckView;
import org.example.common.view.views.deck_view.PicDeckView;
import org.example.guess_card.model.GcStorage;
import org.example.guess_card.model.PointCounter;
import org.example.guess_card.model.rules.Rules;
import org.example.guess_card.view.data_values_view.ColorTextDataView;
import org.example.guess_card.view.data_values_view.TextDataView;

import java.util.List;
import java.util.function.Function;

public class ColorViewFactory extends AbstractViewFactory{
    private final static ColorPrinter.Color COLOR_TITTLE = ColorPrinter.Color.YELLOW;
    private final static ColorPrinter.Color COLOR_DATA = ColorPrinter.Color.BLUE;
    private final static ColorPrinter.Color COLOR_WIN = ColorPrinter.Color.PURPLE;
    private final static ColorPrinter.Color COLOR_HELP = COLOR_TITTLE;
    private final ColorPrinter colorPrinter = new ColorConsolePrinter();
    private final Function<Card, Pic> picCardMapper;

    public ColorViewFactory(Function<Card, Pic> picCardMapper) {
        this.picCardMapper = picCardMapper;
    }

    @Override
    public View tittle() {
        return new ColorMemoInfoView(TITTLE, colorPrinter, COLOR_TITTLE);
    }

    @Override
    public View help(Rules rules, PointCounter counter) {
        String[] strings = textHelp(rules, counter);
        return new ColorMemoInfoView(strings, colorPrinter, COLOR_HELP);
    }

    @Override
    public View card(Card card) {
        return new ColorPicDeckView(card, colorPrinter, picCardMapper);
    }

    @Override
    public View data(List<GcStorage.Data> value) {
        return new ColorTextDataView(value, colorPrinter, COLOR_DATA);
    }

    @Override
    public View win(GcStorage.Data data) {
        String name = data.getPlayer().getName();
        int point = data.getPoint();
        String text = String.format(WIN_TEMPLATE, name, point).toUpperCase();
        return new ColorInfoView(text, colorPrinter, COLOR_WIN);
    }
}
