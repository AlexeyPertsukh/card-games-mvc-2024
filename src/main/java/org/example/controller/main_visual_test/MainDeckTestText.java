package org.example.controller.main_visual_test;

import org.example.model.Deck;
import org.example.view.card_mapper.TextCardMapper;
import org.example.view.views.deck_view.DeckView;
import org.example.view.views.deck_view.TextColorDeckView;
import org.example.view.printer.ColorConsolePrinter;
import org.example.view.printer.ColorPrinter;

public class MainDeckTestText {
    public static void main(String[] args) {
        ColorPrinter printer = new ColorConsolePrinter();
        TextCardMapper mapper = new TextCardMapper();
        DeckView<String> deckView = new TextColorDeckView(printer, mapper);

        for (Deck deck : TestDeckFactory.get()) {
            deckView.show(deck);
        }


    }


}
