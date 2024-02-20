package org.example.guess_card.controller.factory.view_factory;

import org.example.common.view.info_view.InfoView;
import org.example.common.view.info_view.MemoInfoView;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.views.View;

public class BaseViewFactory extends AbstractViewFactory{
    private final Printer printer = new ConsolePrinter();

    public BaseViewFactory() {
    }

    @Override
    public View tittle() {
        return new MemoInfoView(TITTLE, printer);
    }
}
