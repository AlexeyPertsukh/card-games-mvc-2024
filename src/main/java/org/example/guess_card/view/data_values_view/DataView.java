package org.example.guess_card.view.data_values_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;
import org.example.guess_card.model.GcStorage;

import java.util.List;

public abstract class DataView extends AbstractView<List<GcStorage.Data>> {
    public DataView(List<GcStorage.Data> value, Printer printer) {
        super(value, printer);
    }
}
