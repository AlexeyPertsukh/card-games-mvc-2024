package org.example.view.views.view_menu;

import org.example.view.printer.Printer;
import org.example.view.views.view_menu.menu_model.Menu;

import java.util.List;

public abstract class StringsMenuView implements MenuView<String[]>{

    protected final Printer printer;
    private final String textTemplate;


    public StringsMenuView(Printer printer, String textTemplate) {
        this.printer = printer;
        this.textTemplate = textTemplate;
    }

    @Override
    public void show(Menu menu) {
        List<Menu.Item> items = menu.items();
        printer.output(menu.tittle());
        printer.output("-------");
        for (Menu.Item item : items                ) {
            String text = String.format(textTemplate, item.key, item.value);
            printer.output(text);
        }

    }
}
