package org.example.guess_card.controller;

import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;
import org.example.guess_card.controller.factory.dialog_factory.BaseDialogFactory;
import org.example.guess_card.controller.factory.dialog_factory.DialogFactory;
import org.example.guess_card.controller.factory.view_factory.BaseViewFactory;
import org.example.guess_card.controller.factory.view_factory.ViewFactory;
import org.example.guess_card.model.Game;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        ViewFactory viewFactory = new BaseViewFactory();
        DialogFactory dialogFactory = new BaseDialogFactory();
        GameController gameController = new GameController(game, viewFactory, dialogFactory);
        gameController.go();
    }
}
