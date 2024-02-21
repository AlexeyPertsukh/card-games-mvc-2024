package org.example.guess_card.view.data_values_view;

import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.printer.Printer;
import org.example.guess_card.model.GcStorage;

import java.util.List;

public class ColorTextDataView extends DataView {
    private final ColorPrinter colorPrinter;
    private final ColorPrinter.Color color;
    public ColorTextDataView(List<GcStorage.Data> value, ColorPrinter colorPrinter, ColorPrinter.Color color) {
        super(value, colorPrinter);
        this.colorPrinter = colorPrinter;
        this.color = color;
    }

    @Override
    public void show() {
        for (GcStorage.Data data : value) {
            String name = data.getPlayer().getName();
            int point = data.getPoint();
            String text = String.format(TEMPLATE, name, point);
            colorPrinter.colorOutput(color, text);
        }
    }
}
