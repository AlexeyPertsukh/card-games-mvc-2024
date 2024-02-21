package org.example.guess_card.controller.factory.view_factory;

import org.example.common.model.card.Card;
import org.example.common.view.info_view.ColorMemoInfoView;
import org.example.common.view.info_view.MemoInfoView;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorConsolePrinter;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.View;
import org.example.common.view.views.deck_view.ColorPicDeckView;
import org.example.common.view.views.deck_view.PicDeckView;

import java.util.function.Function;

public class ColorViewFactory extends AbstractViewFactory{
    private final static ColorPrinter.Color COLOR_TITTLE = ColorPrinter.Color.BLUE;
    private final static ColorPrinter.Color COLOR_END = ColorPrinter.Color.PURPLE;
    private final static ColorPrinter.Color COLOR_GAME_RESULT = ColorPrinter.Color.BLUE;
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
    public View card(Card card) {
        return new ColorPicDeckView(card, colorPrinter, picCardMapper);
    }
}
