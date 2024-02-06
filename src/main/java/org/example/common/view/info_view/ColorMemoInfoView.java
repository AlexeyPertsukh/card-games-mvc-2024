package org.example.common.view.info_view;

import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.AbstractView;

public class ColorMemoInfoView extends AbstractView<String[]> {
    private final ColorPrinter colorPrinter;
    private final ColorPrinter.Color color;

    public ColorMemoInfoView(String[] value, ColorPrinter colorPrinter, ColorPrinter.Color color) {
        super(value, colorPrinter);
        this.colorPrinter = colorPrinter;
        this.color = color;
    }

    @Override
    public void show() {
        for (String s : value) {
            colorPrinter.colorOutput(color, s);
        }
    }

}
