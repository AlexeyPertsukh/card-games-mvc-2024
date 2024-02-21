package org.example.guess_card.view.data_values_view;

import org.example.common.view.printer.Printer;
import org.example.guess_card.model.GcStorage;

import java.util.List;

public class TextDataView extends DataView {
    public TextDataView(List<GcStorage.Data> value, Printer printer) {
        super(value, printer);
    }

    @Override
    public void show() {
        for (GcStorage.Data data : value) {
            String name = data.getPlayer().getName();
            int point = data.getPoint();
            String text = String.format(TEMPLATE, name, point);
            printer.output(text);
        }
    }
}
