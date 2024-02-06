package org.example.common.view.dialog_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.reader.Reader;
import org.example.common.view.views.view_menu.menu_model.Menu;

import java.util.function.Consumer;

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
