package org.example.view.views.view_menu;

import org.example.view.printer.Printer;

public class BasicStringsMenuView extends StringsMenuView {
    private static final String TEMPLATE = "%s. %s";
    public BasicStringsMenuView(Printer printer) {
        super(printer, TEMPLATE);
    }
}
