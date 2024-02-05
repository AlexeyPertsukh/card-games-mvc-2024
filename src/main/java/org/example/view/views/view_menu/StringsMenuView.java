package org.example.view.views.view_menu;

import org.example.view.views.printer.Printer;
import org.example.view.views.view_menu.menu_model.Menu;

import java.util.List;

public class StringsMenuView implements MenuView<String[]>{
    private static final String TEMPLATE = "%s. %s";
    protected final Printer printer;

    public StringsMenuView(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void show(Menu menu) {
        List<Menu.Item> items = menu.items();
        printer.output(menu.tittle());
        printer.output("-------");
        for (Menu.Item item : items                ) {
            String text = String.format(TEMPLATE, item.key, item.value);
            printer.output(text);
        }
    }
}
