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
import org.example.guess_card.view.data_values_view.TextDataView;

import java.util.List;
import java.util.function.Function;

public class ColorViewFactory extends AbstractViewFactory{
    private final static ColorPrinter.Color COLOR_TITTLE = ColorPrinter.Color.BLUE;
    private final static ColorPrinter.Color COLOR_END = ColorPrinter.Color.PURPLE;
    private final static ColorPrinter.Color COLOR_WIN = ColorPrinter.Color.BLUE;
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
    public View help() {
        return null;//TODO
    }

    @Override
    public View card(Card card) {
        return new ColorPicDeckView(card, colorPrinter, picCardMapper);
    }

    @Override
    public View data(List<GcStorage.Data> value) {
        return new TextDataView(value, colorPrinter);
    }

    @Override
    public View win(GcStorage.Data data) {
        String name = data.getPlayer().getName();
        int point = data.getPoint();
        String text = String.format(WIN_TEMPLATE, name, point);
        return new ColorInfoView(text, colorPrinter, COLOR_WIN);
    }
}
