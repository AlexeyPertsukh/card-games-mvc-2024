package org.example.black_jack.controller;

import org.example.black_jack.controller.factory.dialog_factory.BaseDialogFactory;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.BaseViewFactory;
import org.example.black_jack.controller.factory.view_factory.ColorViewFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.controller.game.Game;
import org.example.black_jack.controller.game.GameAmerican;
import org.example.black_jack.model.BjPointCounter;
import org.example.black_jack.model.Rules;
import org.example.common.model.deck.Deck;
import org.example.common.model.deck_factory.DeckFactory54Card;
import org.example.common.model.player.Player;
import org.example.common.model.player.bot.Ai;
import org.example.common.model.player.bot.Bot;
import org.example.common.model.player.bot.Dealer;
import org.example.common.model.player.bot.DealerAi;
import org.example.common.model.point_counter.PointCounter;
import org.example.common.view.card_mapper.CardMapper;
import org.example.common.view.card_mapper.TextCardMapper;
import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.dialog_view.KeyMenuDialogView;
import org.example.common.view.dialog_view.MinMaxIntegerDialogView;
import org.example.common.view.dialog_view.SelectIntegerDialogView;
import org.example.common.view.factory.card_mapper_factory.PicCardMapperFactory;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;
import org.example.common.view.views.View;
import org.example.common.view.views.view_menu.TextMenuView;
import org.example.common.view.views.view_menu.menu_model.Menu;
import org.example.common.view.views.view_menu.menu_model.NumericMenu;

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

        PointCounter counter = new BjPointCounter();
        Deck deck = (new DeckFactory54Card()).get();

        GameController controller;
        if (isManual(args)) {
            controller = manual(printer, reader, counter, deck);
        } else {
            controller = auto(counter, deck, args);
        }
        controller.go();

    }

    private static boolean isManual(String... args) {
        return args == null || args.length == 0;
    }

    private static GameController controller(ViewFactory viewFactory, DialogFactory dialogFactory, PointCounter counter, Deck deck, Player... players) {
        Game game = new GameAmerican(
                new Rules(),
                counter,
                deck,
                new Dealer("Dealer", counter),
                players
        );
        return new GameController(game, viewFactory, dialogFactory);
    }

    private static GameController auto(PointCounter counter, Deck deck, String... args) {
        Config config = config(args);
        Player[] players = players(counter, config.numPlayer, config.numBot);
        ColorType colorType = colorType(config.colorName);
        CardMapper<Pic> picCardMapper = picCardMapper(config.picName);
        return controller(
                viewFactory(colorType, picCardMapper),
                dialogFactory(),
                counter,
                deck,
                players
        );

    }


    private static GameController manual(Printer printer, Reader reader, PointCounter counter, Deck deck) {
        DialogView<Integer> dialog = dialogPlayers(printer, reader);
        int numPlayer = dialog.input();
        dialog = dialogBots(printer, reader);
        int numBot = dialog.input();
        Player[] players = players(counter, numPlayer, numBot);

        //COLOR
        DialogView<Integer> dialogColor = dialogIntColor(printer, reader);
        int numColor = dialogColor.input();
        ColorType colorType = colorType(numColor);

        //PIC
        CardMapper<Pic> picCardMapper = picCardMapper();

        return controller(
                viewFactory(colorType, picCardMapper),
                dialogFactory(),
                counter,
                deck,
                players
        );
    }

    private static CardMapper<Pic> picCardMapper() {
        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();
        Menu menu = new NumericMenu("COLOR MODE");
        List<String> strings = new ArrayList<>();
        for (PicCardMapperFactory.Type type : PicCardMapperFactory.Type.values()) {
            strings.add(type.name());
        }
        menu.add(strings);
        View menuView = new TextMenuView(menu, printer);

        DialogView<String> dialog = new KeyMenuDialogView(
                printer,
                reader,
                "select:",
                "error",
                menu,
                menuView
        );
        int num = Integer.parseInt(dialog.input()) - 1;
        String name = PicCardMapperFactory.Type.values()[num].name();
        return picCardMapper(name);
    }

    private static CardMapper<Pic> picCardMapper(String key) {
        return (new PicCardMapperFactory()).get(key);
    }


    private static ColorType colorType(int numColor) {
        return ColorType.values()[numColor];
    }

    private static ColorType colorType(String name) {
        return ColorType.valueOf(name);
    }

    private static ViewFactory viewFactory(ColorType type, CardMapper<Pic> picCardMapper) {
        TextCardMapper textCardMapper = new TextCardMapper();
        if (type == ColorType.MONO) {
            return new BaseViewFactory(textCardMapper, picCardMapper);
        }
        return new ColorViewFactory(textCardMapper, picCardMapper);
    }

    private static DialogFactory dialogFactory() {
        return new BaseDialogFactory();
    }

    public static String picMicro1x1() {
        return PicCardMapperFactory.Type.MICRO_1X1.name();
    }

    public static String picMini9x5() {
        return PicCardMapperFactory.Type.MINI_9X5.name();
    }
    public static String picMini5x3() {
        return PicCardMapperFactory.Type.MINI_5X3.name();
    }

    public static String picSmall13x7() {
        return PicCardMapperFactory.Type.SMALL_13X7.name();
    }

    public static String picLarge17X11() {
        return PicCardMapperFactory.Type.LARGE_17X11.name();
    }

    public static String picMini4x3() {
        return PicCardMapperFactory.Type.MINI_4X3.name();
    }

    enum ColorType {
        MONO,
        COL
    }


    private static class Config {
        int numPlayer;
        int numBot;
        String colorName;
        String picName;

        public Config(int numPlayer, int numBot, String colorName, String picName) {
            this.numPlayer = numPlayer;
            this.numBot = numBot;
            this.colorName = colorName;
            this.picName = picName;
        }
    }

    private static Config config(String... args) {
        return new Config(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                args[2],
                args[3]
        );
    }

    private static DialogView<Integer> dialogPlayers(Printer printer, Reader reader) {
        return dialogMinMaxInteger(printer, reader, "Players", 1, 5);
    }

    private static DialogView<Integer> dialogBots(Printer printer, Reader reader) {
        return dialogMinMaxInteger(printer, reader, "Bots", 0, 5);
    }

    private static DialogView<Integer> dialogIntColor(Printer printer, Reader reader) {
        int mono = ColorType.MONO.ordinal();
        int col = ColorType.COL.ordinal();
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


}
