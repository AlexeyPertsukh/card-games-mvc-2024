package org.example.common.view.info_view;


import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;

public class InfoView extends AbstractView<String> {

    public InfoView(String value, Printer printer) {
        super(value, printer);
    }

    @Override
    public void show() {
        printer.output(value);
    }
}
