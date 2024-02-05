package org.example.controller;

import org.example.view.dialog_view.DialogView;
import org.example.view.dialog_view.KeyMenuDialogView;
import org.example.view.views.printer.ConsolePrinter;
import org.example.view.views.printer.Printer;
import org.example.view.views.reader.KeyboardReader;
import org.example.view.views.reader.Reader;
import org.example.view.views.view_menu.BasicStringsMenuView;
import org.example.view.views.view_menu.menu_model.LetterMenu;
import org.example.view.views.view_menu.menu_model.Menu;
import org.example.view.views.view_menu.menu_model.NumericMenu;

public class MainTest {
    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();

        Menu menu = new NumericMenu("TEST");
        menu.add("one");
        menu.add("two");
        menu.add("three");

        var menuView = new BasicStringsMenuView(printer);
        menuView.show(menu);

//        String text = menu.getValue("3");
//        System.out.println(text);
        DialogView<String> dialogView = new KeyMenuDialogView(
                printer,
                reader,
                "input:",
                "error",
                menu,
                menuView::show
                );
        dialogView.input();

    }
}
