package org.example.common.view.dialog_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.reader.Reader;
import org.example.common.view.views.View;
import org.example.common.view.views.view_menu.menu_model.Menu;

import java.util.function.Consumer;

public class KeyMenuDialogView extends SelectStringDialogView{
    private final View view;
    public KeyMenuDialogView(Printer printer, Reader reader, String tittle, String errorMessage, Menu menu, View view) {
        super(printer, reader, tittle, errorMessage, menu.keys());
        this.view = view;
    }

    @Override
    public String input() {
       view.show();
        return super.input();
    }
}
