package org.example.common.view.views.view_menu;

import org.example.common.view.printer.Printer;
import org.example.common.view.views.view_menu.menu_model.Menu;

public class TextMenuView extends AbstractTextMenuView {
    private static final String DEFAULT_TEMPLATE = "%s. %s";

    public TextMenuView(Menu value, Printer printer, String textTemplate) {
        super(value, printer, textTemplate);
    }
    public TextMenuView(Menu value, Printer printer) {
        this(value, printer, DEFAULT_TEMPLATE);
    }

}
