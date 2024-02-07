package org.example.common.view.views.deck_view;

import org.example.common.model.card.CardSuit;
import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.color_mapper.SuitToPrintColorMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ColorPicDeckView extends PicDeckView {
    private final ColorPrinter colorPrinter;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorMapper = new SuitToPrintColorMapper();

    public ColorPicDeckView(Deck value, ColorPrinter colorPrinter, Function<Card, Pic> map) {
        super(value, colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show() {
        if (value.size() == 0) {
            return;
        }

        List<Card> cards = value.toList();
        List<Pic> pictures = new ArrayList<>();

        for (Card card : cards) {
            Pic pic = map.apply(card);
            pictures.add(pic);
        }

        int length = pictures.get(0).size();
        for (int i = 0; i < length; i++) {
            showLine(cards, pictures, i);
        }

    }

    private void showLine(List<Card> cards, List<Pic> pictures, int line) {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            String[] arr = pictures.get(i).value();

            ColorPrinter.Color color = toColor(card);
            colorPrinter.colorOut(color, arr[line]);
        }
        colorPrinter.output("");
    }

    private ColorPrinter.Color toColor(Card card) {
        ColorPrinter.Color color = colorMapper.apply(card.getSuit().getColor());
        return card.isOpen() ? color : ColorPrinter.Color.DEFAULT;
    }

}
