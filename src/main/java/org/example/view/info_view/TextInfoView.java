package org.example.view.info_view;

import org.example.view.printer.Printer;

public class TextInfoView extends AbstractInfoView{
    private final String text;

    public TextInfoView(Printer printer, String text) {
        super(printer);
        this.text = text;
    }

    @Override
    public void show() {
        printer.output(text);
    }
}
