package org.example.common.view.views.deck_view;

import org.example.common.model.card.CardSuit;
import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
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

    public ColorPicDeckView(Card card, ColorPrinter colorPrinter, Function<Card, Pic> map) {
        super(card, colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show() {
        if (value.size() == 0) {
            return;
        }

        List<Card> decks = value.toList();
        List<Pic> pictures = new ArrayList<>();

        for (Card deck : decks) {
            Pic pic = map.apply(deck);
            pictures.add(pic);
        }

        int length = pictures.get(0).size();
        for (int i = 0; i < length; i++) {
            showLine(decks, pictures, i);
        }

    }

    private void showLine(List<Card> decks, List<Pic> pictures, int line) {
        for (int i = 0; i < decks.size(); i++) {
            Card deck = decks.get(i);
            String[] arr = pictures.get(i).value();

            ColorPrinter.Color color = toColor(deck);
            colorPrinter.colorOut(color, arr[line]);
        }
        colorPrinter.output("");
    }

    private ColorPrinter.Color toColor(Card deck) {
        ColorPrinter.Color color = colorMapper.apply(deck.getSuit().getColor());
        return deck.isOpen() ? color : ColorPrinter.Color.DEFAULT;
    }

}
