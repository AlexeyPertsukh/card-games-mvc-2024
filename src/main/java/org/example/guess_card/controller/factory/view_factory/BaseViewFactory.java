package org.example.guess_card.controller.factory.view_factory;

import org.example.common.model.card.Card;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.info_view.MemoInfoView;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.View;
import org.example.common.view.views.deck_view.PicDeckView;
import org.example.guess_card.model.GcStorage;
import org.example.guess_card.model.PointCounter;
import org.example.guess_card.model.rules.Rules;
import org.example.guess_card.view.data_values_view.TextDataView;

import java.util.List;
import java.util.function.Function;

public class BaseViewFactory extends AbstractViewFactory{
    private final Printer printer = new ConsolePrinter();
    private final Function<Card, Pic> picCardMapper;

    public BaseViewFactory(Function<Card, Pic> picCardMapper) {
        this.picCardMapper = picCardMapper;
    }

    @Override
    public View tittle() {
        return new MemoInfoView(TITTLE, printer);
    }

    @Override
    public View help(Rules rules, PointCounter counter) {
        String[] strings = textHelp(rules, counter);
        return new MemoInfoView(strings, printer);
    }

    @Override
    public View card(Card card) {
        return new PicDeckView(card, printer, picCardMapper);
    }
    @Override
    public View data(List<GcStorage.Data> value) {
        return new TextDataView(value, printer);
    }

    @Override
    public View win(GcStorage.Data data) {
        String name = data.getPlayer().getName();
        int point = data.getPoint();
        String text = String.format(WIN_TEMPLATE, name, point).toUpperCase();
        return new InfoView(text, printer);
    }
}
