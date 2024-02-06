package org.example.controller;

import org.example.controller.factory.DialogFactory;
import org.example.controller.factory.ViewFactory;
import org.example.model.Deck;
import org.example.model.Rules;
import org.example.model.deck_factory.DeckFactory54Card;
import org.example.model.game.Game;
import org.example.model.game.GameAmerican;
import org.example.model.game.PlayerData;
import org.example.model.player.Player;
import org.example.model.player.bot.Ai;
import org.example.model.player.bot.Bot;
import org.example.model.player.bot.Dealer;
import org.example.model.player.bot.DealerAi;
import org.example.model.point_counter.BjPointCounter;
import org.example.model.point_counter.PointCounter;
import org.example.view.card_mapper.*;
import org.example.view.dialog_view.DialogView;
import org.example.view.dialog_view.KeyMenuDialogView;
import org.example.view.dialog_view.MinMaxIntegerDialogView;
import org.example.view.dialog_view.SelectIntegerDialogView;
import org.example.view.views.View;
import org.example.view.views.card_view.CardView;
import org.example.view.views.card_view.StringsCardView;
import org.example.view.views.card_view.StringsColorCardView;
import org.example.view.views.deck_view.*;
import org.example.view.printer.ColorConsolePrinter;
import org.example.view.printer.ConsolePrinter;
import org.example.view.printer.Printer;
import org.example.view.reader.KeyboardReader;
import org.example.view.reader.Reader;
import org.example.view.views.player_data_view.ColorTextPdataView;
import org.example.view.views.player_data_view.TextPdataView;
import org.example.view.views.view_menu.BasicStringsMenuView;
import org.example.view.views.view_menu.MenuView;
import org.example.view.views.view_menu.menu_model.Menu;
import org.example.view.views.view_menu.menu_model.NumericMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MainConfig {
    public final static String MICRO_PIC = "1";
    public final static String MINI_PIC = "2";
    public final static String SMALL_PIC = "3";
    public final static String LARGE_PIC = "4";

    public final static String COLOR_MONO = "1";
    public final static String COLOR_COL = "2";

    private final static String ERROR_MESSAGE = "input error";

    public static void main(String... args) {

        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();

        PointCounter counter = BjPointCounter.getInstance();

        Deck deck = (new DeckFactory54Card()).get();

        Config config = null;
        boolean isManual = true;
        if(args != null && args.length > 0) {
            config = config(args);
            isManual = false;
        }


        //PLAYERS
        int numPlayer = 0;
        int numBot = 0;

        if(isManual) {
            DialogView<Integer> dialog = dialogPlayers(printer, reader);
            numPlayer = dialog.input();
            dialog = dialogBots(printer, reader);
            numBot = dialog.input();
            Player[] players = players(counter, numPlayer, numBot);
        } else {
            numPlayer = config.numPlayer;
            numBot = config.numBot;
        }

        Player[] players = players(counter, numPlayer, numBot);

        //CARD PIC
        int numCardPic = 0;

        if(isManual) {
            DialogView<String> dialogCardPic = dialogCardPicture(printer, reader);
            String key = dialogCardPic.input();
            numCardPic = Integer.parseInt(key);
        } else {
            numCardPic = config.numCardPic;
        }

        CardMapper<String[]> picCardMapper = picCardMapper(String.valueOf(numCardPic));

        //COLOR
        int numColor = 0;

        if(isManual) {
            DialogView<Integer> dialogColor = dialogIntColor(printer, reader);
            numColor = dialogColor.input();
        } else {
            numColor = config.numColor;
        }
        Color color = color(numColor);

        //PIC DECK VIEW
        StringsDeckView pickDeckView = picDeckView(color, picCardMapper);

        //CARD VIEW
        CardView<String[]> picCardView = picCardView(color, picCardMapper);

        //TABLE DATA VIEW
        CardMapper<String> textCardMapper = TextCardMapper.getInstance();
        View<List<PlayerData>> tableDataView = tableDataView(color, textCardMapper);

        Dealer dealer = new Dealer("Dealer", BjPointCounter.getInstance());

        Game game = new GameAmerican(
                Rules.getInstance(),
                BjPointCounter.getInstance(),
                deck,
                dealer,
                players
        );

        GameController gameController = new GameController(
                game,
                new DialogFactory(printer, reader),
                new ViewFactory(
                        printer,
                        pickDeckView,
                        picCardView,
                        tableDataView
                )
        );

        gameController.go();

    }

    private static class Config {
        int numPlayer;
        int numBot;
        int numCardPic;
        int numColor;

        public Config(int numPlayer, int numBot, int numCardPic, int numColor) {
            this.numPlayer = numPlayer;
            this.numBot = numBot;
            this.numCardPic = numCardPic;
            this.numColor = numColor;
        }
    }

    private static Config config(String... args) {

        return new Config(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3])
        );
    }

    private static DialogView<Integer> dialogPlayers(Printer printer, Reader reader) {
        return dialogMinMaxInteger(printer, reader, "Players", 1, 5);
    }

    private static DialogView<Integer> dialogBots(Printer printer, Reader reader) {
        return dialogMinMaxInteger(printer, reader, "Bots", 0, 5);
    }

    private static DialogView<Integer> dialogIntColor(Printer printer, Reader reader) {
        int mono = 1;
        int col = 2;
        String tittle = String.format("%d - mono, %d - color :", mono, col);
        return dialogSelectInteger(printer, reader, tittle, mono, col);
    }
    private static DialogView<Integer> dialogMinMaxInteger(Printer printer, Reader reader, String name, int min, int max) {

        String tittle = String.format("%s (%d - %d): ", name, min, max);
        return new MinMaxIntegerDialogView(
                printer,
                reader,
                tittle,
                ERROR_MESSAGE,
                0,
                5
        );
    }

    private static DialogView<Integer> dialogSelectInteger(Printer printer, Reader reader, String tittle, int... numbers) {

        return new SelectIntegerDialogView(
                printer,
                reader,
                tittle,
                ERROR_MESSAGE,
                numbers
        );
    }

    private static Player[] players(Function<Deck, Integer> counter, int numPlayer, int numBot) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayer; i++) {
            Player player = new Player("Player " + (i + 1));
            players.add(player);
        }
        for (int i = 0; i < numBot; i++) {
            Ai ai = new DealerAi();
            Bot bot = new Bot("Bot " + (i + 1), ai, counter);
            players.add(bot);
        }
        return players.toArray(new Player[0]);
    }

    private static DialogView<String> dialogCardPicture(Printer printer, Reader reader) {
        Menu menu = new NumericMenu("CARD PICTURES");
        menu.add("MICRO");
        menu.add("MINI");
        menu.add("SMALL");
        menu.add("LARGE");

        MenuView<String[]> view = new BasicStringsMenuView(printer);

        return new KeyMenuDialogView(printer, reader, "select:", ERROR_MESSAGE, menu, view::show);
    }

    private static CardMapper<String[]> picCardMapper(String arg) {
        switch (arg) {
            case MICRO_PIC:
                return new MicroPicCardMapper();
            case MINI_PIC:
                return new MiniPicCardMapper();
            case SMALL_PIC:
                return new SmallPicCardMapper();
            case LARGE_PIC:
                return new LargePicCardMapper();
            default:
                throw new IllegalArgumentException("cardStringMapper");
        }
    }


    //new StringsColorDeckView(colorPrinter, cardMapper),
    private static StringsDeckView picDeckView(Color color, CardMapper<String[]> cardMapper) {
        if(color == Color.MONO) {
            return new StringsDeckView(new ColorConsolePrinter(), cardMapper);
        }
        return new ColorPicDeckView(new ColorConsolePrinter(), cardMapper);
    }
    private static DeckView<String> textDeckView(Color color, CardMapper<String> cardMapper) {
        if(color == Color.MONO) {
            return new TextDeckView(new ConsolePrinter(), cardMapper);
        }
        return new TextColorDeckView(new ColorConsolePrinter(), cardMapper);
    }

    private static CardView<String[]> picCardView(Color color, CardMapper<String[]> cardMapper) {
        if(color == Color.MONO) {
            return new StringsCardView(new ConsolePrinter(), cardMapper);
        }
        return new StringsColorCardView(new ColorConsolePrinter(), cardMapper);
    }

    private static View<List<PlayerData>> tableDataView(Color color, CardMapper<String> cardMapper) {
        if(color == Color.MONO) {
            return new TextPdataView(new ConsolePrinter(), cardMapper);
        }
        return new ColorTextPdataView(new ColorConsolePrinter(), cardMapper);
    }

    private static Color color(int num) {
        switch (num) {
            case 1: return Color.MONO;
            case 2: return Color.COL;
            default:
                throw new IllegalArgumentException("color");
        }
    }

    enum Color {
        MONO,
        COL
    }


}
