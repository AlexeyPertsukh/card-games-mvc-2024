package org.example.common.view.views.view_menu;

import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;
import org.example.common.view.views.View;
import org.example.common.view.views.view_menu.menu_model.Menu;

import java.util.List;

public abstract class AbstractTextMenuView extends AbstractView<Menu> {

    protected final Printer printer;
    private final String textTemplate;


    public AbstractTextMenuView(Menu value, Printer printer, String textTemplate) {
        super(value, printer);
        this.printer = printer;
        this.textTemplate = textTemplate;
    }

    @Override
    public void show() {
        List<Menu.Item> items = value.items();
        printer.output(value.tittle());
        printer.output("-------");
        for (Menu.Item item : items) {
            String text = String.format(textTemplate, item.key, item.value);
            printer.output(text);
        }
    }
}
