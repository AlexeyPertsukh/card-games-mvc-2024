package org.example.common.view.info_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;

public class StringsInfoView extends AbstractView<String[]> {
    public StringsInfoView(String[] value, Printer printer) {
        super(value, printer);
    }

    @Override
    public void show() {
        for (String s : value) {
            printer.output(s);
        }
    }

}
