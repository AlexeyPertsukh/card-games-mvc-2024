package org.example.controller;

import org.example.view.views.printer.ColorPrinter;
import org.example.view.views.printer.ConsolePrinter;
import org.example.view.views.printer.Printer;
import org.example.view.views.view_menu.MenuView;
import org.example.view.views.view_menu.StringsMenuView;
import org.example.view.views.view_menu.menu_model.Menu;
import org.example.view.views.view_menu.menu_model.NumericMenu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        var menuView = new StringsMenuView(printer);
        menuView.show(menu);

        String text = menu.getValue("12");
        System.out.println(text);

    }
}
