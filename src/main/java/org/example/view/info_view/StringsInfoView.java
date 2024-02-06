package org.example.view.info_view;

import org.example.view.printer.Printer;

public class StringsInfoView extends AbstractInfoView {
    private final String[] strings;

    public StringsInfoView(Printer printer, String[] strings) {
        super(printer);
        this.strings = strings;
    }

    @Override
    public void show() {
        for (String s : strings) {
            printer.output(s);
        }
    }

}
