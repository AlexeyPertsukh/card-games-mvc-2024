package org.example.view.dialog_view;

import org.example.view.views.printer.Printer;
import org.example.view.views.reader.Reader;
import org.example.view.views.view_menu.menu_model.Menu;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class KeyMenuDialogView extends SelectStringDialogView{
    private final Menu menu;
    private final Consumer<Menu> showMenu;
    public KeyMenuDialogView(Printer printer, Reader reader, String tittle, String errorMessage, Menu menu, Consumer<Menu> showMenu) {
        super(printer, reader, tittle, errorMessage, menu.keys());
        this.menu = menu;
        this.showMenu = showMenu;
    }

    @Override
    public String input() {
        showMenu.accept(menu);
        return super.input();
    }
}
