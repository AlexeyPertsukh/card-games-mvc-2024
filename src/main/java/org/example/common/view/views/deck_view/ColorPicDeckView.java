package org.example.common.view.views.deck_view;

import org.example.common.model.card.CardSuit;
import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.color_mapper.SuitToPrintColorMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ColorPicDeckView extends PicDeckView {
    private final ColorPrinter colorPrinter;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorMapper = new SuitToPrintColorMapper();

    public ColorPicDeckView(Deck value, ColorPrinter colorPrinter, Function<Card, String[]> map) {
        super(value, colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show() {
        if (value.size() == 0) {
            return;
        }

        List<Card> cards = value.toList();
        List<String[]> pictures = new ArrayList<>();

        for (Card card : cards) {
            String[] pic = map.apply(card);
            pictures.add(pic);
        }

        int length = pictures.get(0).length;
        for (int i = 0; i < length; i++) {
            showLine(cards, pictures, i);
        }

    }

    private void showLine(List<Card> cards, List<String[]> pictures, int line) {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            String[] pic = pictures.get(i);
            ColorPrinter.Color color = colorMapper.apply(card.getSuit().getColor());
            colorPrinter.colorOut(color, pic[line]);
        }
        colorPrinter.output("");
    }


}
