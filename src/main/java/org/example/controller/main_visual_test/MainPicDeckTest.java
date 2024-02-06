package org.example.controller.main_visual_test;

import org.example.model.Deck;
import org.example.view.card_mapper.*;
import org.example.view.views.deck_view.ColorPicDeckView;
import org.example.view.views.deck_view.DeckView;
import org.example.view.printer.ColorConsolePrinter;
import org.example.view.printer.ColorPrinter;

public class MainPicDeckTest {
    public static final String MICRO_PIC = "micro";
    public static final String MINI_PIC = "mini";
    public static final String SMALL_PIC = "small";
    public static final String LARGE_PIC = "large";
    public static void main(String... args) {

        String type = MICRO_PIC;
        if(args != null && args.length > 0) {
            type = args[0];
        }

        DeckView<String[]> deckView = deckView(type);
        for (Deck deck : TestDeckFactory.get()) {
            deckView.show(deck);
        }

    }

    private static DeckView<String[]> deckView(String type) {
        ColorPrinter colorPrinter = new ColorConsolePrinter();
        CardMapper<String[]> cardMapper = cardMapper(type);
        return new ColorPicDeckView(colorPrinter, cardMapper);
    }

    private static CardMapper<String[]> cardMapper(String type) {
        switch (type) {
            case MICRO_PIC: return new MicroPicCardMapper();
            case MINI_PIC: return new MiniPicCardMapper();
            case SMALL_PIC: return new SmallPicCardMapper();
            case LARGE_PIC: return new MicroPicCardMapper();
            default: throw new IllegalArgumentException("MainDeckTestPic.cardMapper");
        }
    }



}
