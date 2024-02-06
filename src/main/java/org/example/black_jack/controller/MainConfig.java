package org.example.black_jack.controller;

import org.example.common.view.factory.card_mapper_factory.PicCardMapperFactory;

public class MainConfig {
    public final static String MICRO_PIC = "1";
    public final static String MINI_PIC = "2";
    public final static String SMALL_PIC = "3";
    public final static String LARGE_PIC = "4";

    public final static String COLOR_MONO = "1";
    public final static String COLOR_COL = "2";

    private final static String ERROR_MESSAGE = "input error";

    public static void main(String... args) {
//
//        Printer printer = new ConsolePrinter();
//        Reader reader = new KeyboardReader();
//
//        PointCounter counter = BjPointCounter.getInstance();
//
//        Deck deck = (new DeckFactory54Card()).get();
//
//        Config config = null;
//        boolean isManual = true;
//        if (args != null && args.length > 0) {
//            config = config(args);
//            isManual = false;
//        }
//
//
//        //PLAYERS
//        int numPlayer = 0;
//        int numBot = 0;
//
//        if (isManual) {
//            DialogView<Integer> dialog = dialogPlayers(printer, reader);
//            numPlayer = dialog.input();
//            dialog = dialogBots(printer, reader);
//            numBot = dialog.input();
//            Player[] players = players(counter, numPlayer, numBot);
//        } else {
//            numPlayer = config.numPlayer;
//            numBot = config.numBot;
//        }
//
//        Player[] players = players(counter, numPlayer, numBot);
//
//        //CARD PIC
//        String cardPic = "";
//
//        if (isManual) {
//            DialogView<String> dialogCardPic = dialogCardPicture(printer, reader);
//            String key = dialogCardPic.input();
//            cardPic = PicCardMapperFactory.Type.values()[Integer.parseInt(key)].name();
//        } else {
//            cardPic = config.cardPic;
//        }
//
//        CardMapper<String[]> picCardMapper = picCardMapper(cardPic);
//
//        //COLOR
//        int numColor = 0;
//
//        if (isManual) {
//            DialogView<Integer> dialogColor = dialogIntColor(printer, reader);
//            numColor = dialogColor.input();
//        } else {
//            numColor = config.numColor;
//        }
//        Color color = color(numColor);
//
//        //PIC DECK VIEW
//        PicDeckView pickDeckView = picDeckView(color, picCardMapper);
//
//        //CARD VIEW
//        CardView<String[]> picCardView = picCardView(color, picCardMapper);
//
//        //TABLE DATA VIEW
//        CardMapper<String> textCardMapper = TextCardMapper.getInstance();
//        View<List<PlayerData>> tableDataView = tableDataView(color, textCardMapper);
//
//        Dealer dealer = new Dealer("Dealer", BjPointCounter.getInstance());
//
//        Game game = new GameAmerican(
//                Rules.getInstance(),
//                BjPointCounter.getInstance(),
//                deck,
//                dealer,
//                players
//        );
//
//        GameController gameController = new GameController(
//                game,
//                new DialogFactory(printer, reader),
//                new OldViewFactory(
//                        printer,
//                        pickDeckView,
//                        picCardView,
//                        tableDataView
//                )
//        );
//
//        gameController.go();

    }


//    private static class Config {
//        int numPlayer;
//        int numBot;
//        String cardPic;
//        int numColor;
//
//        public Config(int numPlayer, int numBot, String cardPic, int numColor) {
//            this.numPlayer = numPlayer;
//            this.numBot = numBot;
//            this.cardPic = cardPic;
//            this.numColor = numColor;
//        }
//    }
//
//    private static Config config(String... args) {
//
//        return new Config(
//                Integer.parseInt(args[0]),
//                Integer.parseInt(args[1]),
//                args[2],
//                Integer.parseInt(args[3])
//        );
//    }
//
//    private static DialogView<Integer> dialogPlayers(Printer printer, Reader reader) {
//        return dialogMinMaxInteger(printer, reader, "Players", 1, 5);
//    }
//
//    private static DialogView<Integer> dialogBots(Printer printer, Reader reader) {
//        return dialogMinMaxInteger(printer, reader, "Bots", 0, 5);
//    }
//
//    private static DialogView<Integer> dialogIntColor(Printer printer, Reader reader) {
//        int mono = 1;
//        int col = 2;
//        String tittle = String.format("%d - mono, %d - color :", mono, col);
//        return dialogSelectInteger(printer, reader, tittle, mono, col);
//    }
//
//    private static DialogView<Integer> dialogMinMaxInteger(Printer printer, Reader reader, String name, int min, int max) {
//
//        String tittle = String.format("%s (%d - %d): ", name, min, max);
//        return new MinMaxIntegerDialogView(
//                printer,
//                reader,
//                tittle,
//                ERROR_MESSAGE,
//                0,
//                5
//        );
//    }
//
//    private static DialogView<Integer> dialogSelectInteger(Printer printer, Reader reader, String tittle, int... numbers) {
//
//        return new SelectIntegerDialogView(
//                printer,
//                reader,
//                tittle,
//                ERROR_MESSAGE,
//                numbers
//        );
//    }
//
//    private static Player[] players(Function<Deck, Integer> counter, int numPlayer, int numBot) {
//        List<Player> players = new ArrayList<>();
//        for (int i = 0; i < numPlayer; i++) {
//            Player player = new Player("Player " + (i + 1));
//            players.add(player);
//        }
//        for (int i = 0; i < numBot; i++) {
//            Ai ai = new DealerAi();
//            Bot bot = new Bot("Bot " + (i + 1), ai, counter);
//            players.add(bot);
//        }
//        return players.toArray(new Player[0]);
//    }
//
//    private static DialogView<String> dialogCardPicture(Printer printer, Reader reader) {
//        PicCardMapperFactory.Type[] types = PicCardMapperFactory.Type.values();
//
//        Menu menu = new NumericMenu("CARD PICTURES");
//        for (PicCardMapperFactory.Type type : types) {
//            menu.add(type.name());
//        }
//
//        MenuView<String[]> view = new TextMenuView(printer);
//
//        return new KeyMenuDialogView(printer, reader, "select:", ERROR_MESSAGE, menu, view::show);
//    }
//
//    private static CardMapper<String[]> picCardMapper(String value) {
//        PicCardMapperFactory factory = new PicCardMapperFactory();
//        return factory.get(value);
//
//    }
//
//
//    //new StringsColorDeckView(colorPrinter, cardMapper),
//    private static PicDeckView picDeckView(Color color, CardMapper<String[]> cardMapper) {
//        if (color == Color.MONO) {
//            return new PicDeckView(new ColorConsolePrinter(), cardMapper);
//        }
//        return new ColorPicDeckView(new ColorConsolePrinter(), cardMapper);
//    }
//
//    private static DeckView<String> textDeckView(Color color, CardMapper<String> cardMapper) {
//        if (color == Color.MONO) {
//            return new TextDeckView(new ConsolePrinter(), cardMapper);
//        }
//        return new ColorTextDeckView(new ColorConsolePrinter(), cardMapper);
//    }
//
//    private static CardView<String[]> picCardView(Color color, CardMapper<String[]> cardMapper) {
//        if (color == Color.MONO) {
//            return new PicCardView(new ConsolePrinter(), cardMapper);
//        }
//        return new ColorPicCardView(new ColorConsolePrinter(), cardMapper);
//    }
//
//    private static View<List<PlayerData>> tableDataView(Color color, CardMapper<String> cardMapper) {
//        if (color == Color.MONO) {
//            return new TextPdataView(new ConsolePrinter(), cardMapper);
//        }
//        return new ColorTextPdataView(new ColorConsolePrinter(), cardMapper);
//    }
//
//    private static Color color(int num) {
//        switch (num) {
//            case 1:
//                return Color.MONO;
//            case 2:
//                return Color.COL;
//            default:
//                throw new IllegalArgumentException("color");
//        }
//    }

    public static String picMicro() {
        return PicCardMapperFactory.Type.MICRO.name();
    }

    public static String picMini() {
        return PicCardMapperFactory.Type.MINI.name();
    }

    public static String picSmall() {
        return PicCardMapperFactory.Type.SMALL.name();
    }

    public static String picLarge() {
        return PicCardMapperFactory.Type.LARGE.name();
    }

    enum Color {
        MONO,
        COL
    }



}
