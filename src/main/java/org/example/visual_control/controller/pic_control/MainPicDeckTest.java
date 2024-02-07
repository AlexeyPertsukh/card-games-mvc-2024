package org.example.visual_control.controller.pic_control;

import org.example.common.view.card_mapper.*;
import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.dialog_view.KeyMenuDialogView;
import org.example.common.view.dialog_view.SelectIntegerDialogView;
import org.example.common.view.factory.card_mapper_factory.PicCardMapperFactory;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorConsolePrinter;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;
import org.example.common.view.views.View;
import org.example.common.model.deck.Deck;
import org.example.common.view.views.deck_view.ColorPicDeckView;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.view_menu.TextMenuView;
import org.example.common.view.views.view_menu.menu_model.Menu;
import org.example.common.view.views.view_menu.menu_model.NumericMenu;

import java.util.ArrayList;
import java.util.List;


public class MainPicDeckTest {

    public static void main(String... args) {
        ColorPrinter colorPrinter = new ColorConsolePrinter();
        Reader reader = new KeyboardReader();

        CardMapper<Pic> picCardMapper;
        do {
            if (isManual(args)) {
                picCardMapper = manual(colorPrinter, reader);
            } else {
                picCardMapper = auto(args[0]);
            }

            for (Deck deck : TestDeckFactory.get()) {
                View deckView = new ColorPicDeckView(deck, colorPrinter, picCardMapper);
                deckView.show();
            }

            if(isManual(args)) {
                int out = 0;
                int again = 1;
                String tittle = "0 - exit, 1 - choose again : ";
                DialogView<Integer> dialog = new SelectIntegerDialogView(
                        colorPrinter,
                        reader,
                        tittle,
                        "err",
                        out,
                        again
                );
                if(dialog.input() == out) {
                    return;
                }
            }

        } while (isManual(args));


    }


    private static boolean isManual(String... args) {
        return args == null || args.length == 0;
    }

    private static CardMapper<Pic> auto(String s) {
        PicCardMapperFactory picCardMapperFactory = new PicCardMapperFactory();
        return picCardMapperFactory.get(s);
    }

    private static CardMapper<Pic> manual(ColorPrinter colorPrinter, Reader reader) {

        PicCardMapperFactory.Type[] types = PicCardMapperFactory.Type.values();
        List<String> list = new ArrayList<>();
        for (PicCardMapperFactory.Type type : types) {
            list.add(type.name());
        }

        Menu menu = new NumericMenu("CARD PICTURES");
        menu.add(list);

        View viewMenu = new TextMenuView(menu, colorPrinter);

        DialogView<String> dialog = new KeyMenuDialogView(colorPrinter, reader, "select: ", "err", menu, viewMenu);
        String numKey = dialog.input();
        int index = Integer.parseInt(numKey) - 1;
        PicCardMapperFactory.Type type = types[index];

        PicCardMapperFactory picCardMapperFactory = new PicCardMapperFactory();
        return picCardMapperFactory.get(type);
    }





}
