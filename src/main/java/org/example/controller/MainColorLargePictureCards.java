package org.example.controller;

import org.example.controller.factory.DialogFactory;
import org.example.controller.factory.ViewFactory;
import org.example.model.Deck;
import org.example.model.Rules;
import org.example.model.deck_factory.DeckFactory54Card;
import org.example.model.game.Game;
import org.example.model.game.GameAmerican;
import org.example.model.player.Player;
import org.example.model.player.bot.Bot;
import org.example.model.player.bot.Dealer;
import org.example.model.player.bot.DealerAi;
import org.example.model.point_counter.BjPointCounter;
import org.example.view.card_mapper.CardMapper;
import org.example.view.card_mapper.LargeStringsCardMapper;
import org.example.view.card_mapper.SmallStringsCardMapper;
import org.example.view.card_mapper.TextCardMapper;
import org.example.view.views.card_view.StringsColorCardView;
import org.example.view.views.deck_view.StringsColorDeckView;
import org.example.view.views.printer.ColorConsolePrinter;
import org.example.view.views.printer.ColorPrinter;
import org.example.view.views.printer.ConsolePrinter;
import org.example.view.views.printer.Printer;
import org.example.view.views.reader.KeyboardReader;
import org.example.view.views.reader.Reader;
import org.example.view.views.table_data_view.TextColorTableDataView;

public class MainColorLargePictureCards {
    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        ColorPrinter colorPrinter = new ColorConsolePrinter();
        Reader reader = new KeyboardReader();
        Deck deck = (new DeckFactory54Card()).get();
        Player firstPlayer = new Player("Player 1");
        Player playerA = new Player("PlayerA");
        Player secondPlayer = new Bot("Player 2", new DealerAi(), BjPointCounter.getInstance());
        Dealer dealer = new Dealer("Dealer", BjPointCounter.getInstance());

        CardMapper<String[]> cardMapper = LargeStringsCardMapper.getInstance();

        Game game = new GameAmerican(
                Rules.getInstance(),
                BjPointCounter.getInstance(),
                deck,
                dealer,
                firstPlayer,
                playerA
//                secondPlayer
        );

        GameController gameController = new GameController(
                game,
                new DialogFactory(printer, reader),
                new ViewFactory(
                        printer,
                        SmallStringsCardMapper.getInstance(),
                        new StringsColorDeckView(colorPrinter, cardMapper),
                        new StringsColorCardView(colorPrinter, cardMapper),
                        new TextColorTableDataView(colorPrinter, TextCardMapper.getInstance()))
        );

        gameController.go();

    }
}