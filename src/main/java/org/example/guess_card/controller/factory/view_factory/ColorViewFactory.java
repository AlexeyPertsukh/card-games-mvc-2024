package org.example.guess_card.controller.factory.view_factory;

import org.example.common.model.card.Card;
import org.example.common.view.info_view.MemoInfoView;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.View;
import org.example.common.view.views.deck_view.PicDeckView;

import java.util.function.Function;

public class ColorViewFactory extends AbstractViewFactory{
    private final Printer printer = new ConsolePrinter();
    private final Function<Card, Pic> picCardMapper;

    public ColorViewFactory(Function<Card, Pic> picCardMapper) {
        this.picCardMapper = picCardMapper;
    }

    @Override
    public View tittle() {
        return new MemoInfoView(TITTLE, printer);
    }

    @Override
    public View card(Card card) {
        return new PicDeckView(card, printer, picCardMapper);
    }
}
