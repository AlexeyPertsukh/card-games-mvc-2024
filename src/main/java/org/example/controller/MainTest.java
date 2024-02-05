package org.example.controller;

import org.example.view.views.printer.ConsolePrinter;
import org.example.view.views.printer.Printer;
import org.example.view.views.view_menu.BasicStringsMenuView;
import org.example.view.views.view_menu.menu_model.LetterMenu;
import org.example.view.views.view_menu.menu_model.Menu;
import org.example.view.views.view_menu.menu_model.NumericMenu;

public class MainTest {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("1","1");
//        map.put("1","2");
//        System.out.println(map.get("1"));
        Printer printer = new ConsolePrinter();
        Menu menu = new NumericMenu("TEST");
        menu.add("one");
        menu.add("two");
        menu.add("three");

        var menuView = new BasicStringsMenuView(printer);
        menuView.show(menu);

        String text = menu.getValue("b");
        System.out.println(text);

    }
}
