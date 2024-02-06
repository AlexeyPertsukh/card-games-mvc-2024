package org.example.common.view.info_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.views.AbstractView;

public class MemoInfoView extends AbstractView<String[]> {
    public MemoInfoView(String[] value, Printer printer) {
        super(value, printer);
    }

    @Override
    public void show() {
        for (String s : value) {
            printer.output(s);
        }
    }

}
