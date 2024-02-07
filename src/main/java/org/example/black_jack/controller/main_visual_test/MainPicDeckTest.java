package org.example.black_jack.controller.main_visual_test;

import org.example.common.view.card_mapper.CardMapper;
import org.example.common.view.card_mapper.Micro1x1PicCardMapper;
import org.example.common.view.card_mapper.Mini9x5PicCardMapper;
import org.example.common.view.card_mapper.Small13x7PicCardMapper;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorConsolePrinter;
import org.example.common.view.views.View;
import org.example.common.model.deck.Deck;
import org.example.common.view.views.deck_view.ColorPicDeckView;
import org.example.common.view.printer.ColorPrinter;

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


        for (Deck deck : TestDeckFactory.get()) {
            View deckView = deckView(type, deck);
            deckView.show();
        }

    }

    private static View deckView(String type, Deck deck) {
        ColorPrinter colorPrinter = new ColorConsolePrinter();
        CardMapper<Pic> cardMapper = cardMapper(type);
        return new ColorPicDeckView(deck, colorPrinter, cardMapper);
    }

    private static CardMapper<Pic> cardMapper(String type) {
        switch (type) {
            case MICRO_PIC: return new Micro1x1PicCardMapper();
            case MINI_PIC: return new Mini9x5PicCardMapper();
            case SMALL_PIC: return new Small13x7PicCardMapper();
            case LARGE_PIC: return new Micro1x1PicCardMapper();
            default: throw new IllegalArgumentException("MainDeckTestPic.cardMapper");
        }
    }



}
