package org.example.view.info_view;

import org.example.view.views.printer.Printer;

public abstract class AbstractInfoView implements InfoView{
    protected final Printer printer;

    public AbstractInfoView(Printer printer) {
        this.printer = printer;
    }

}
