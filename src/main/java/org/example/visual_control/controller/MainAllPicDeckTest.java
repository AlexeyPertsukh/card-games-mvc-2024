package org.example.visual_control.controller;

import org.example.common.view.factory.card_mapper_factory.PicCardMapperFactory;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;

public class MainAllPicDeckTest {

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        PicCardMapperFactory.Type[] types = PicCardMapperFactory.Type.values();

        int num = 0;
        for (PicCardMapperFactory.Type type:types             ) {
            String name = type.name();
            String text = String.format("\n=================================== %d.  %s ", num++, name);
            printer.output(text);
            MainPicDeckTest.main(name);
        }
    }
}
