package org.example.controller.main_visual_test;

import org.example.model.Deck;
import org.example.view.card_mapper.MicroStringsCardMapper;
import org.example.view.card_mapper.StringsCardMapper;
import org.example.view.views.deck_view.DeckView;
import org.example.view.views.deck_view.StringsColorDeckView;
import org.example.view.views.printer.ColorConsolePrinter;
import org.example.view.views.printer.ColorPrinter;

public class MainDeckTestMicroPic {
    public static void main(String[] args) {
        ColorPrinter printer = new ColorConsolePrinter();
        StringsCardMapper mapper = new MicroStringsCardMapper();
        DeckView<String[]> deckView = new StringsColorDeckView(printer, mapper);

        for (Deck deck : TestDeckFactory.get()) {
            deckView.show(deck);
        }


    }


}
