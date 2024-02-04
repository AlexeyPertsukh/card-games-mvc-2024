package org.example.view.views.printer;

public class ColorConsolePrinter extends ConsolePrinter implements ColorPrinter{

    @Override
    public void colorOutput(Color color, String text) {
        colorOut(color, text);
        output("");
    }

    public void colorOut(Color color, String text) {
        System.out.print(color.getCode());
        out(text);
        System.out.print(Color.RESET.getCode());
    }

}
