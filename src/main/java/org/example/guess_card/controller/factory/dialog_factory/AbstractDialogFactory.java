package org.example.guess_card.controller.factory.dialog_factory;

public abstract class AbstractDialogFactory implements DialogFactory{
    protected static final String DEFAULT_CONTINUE_KEY = "y";
    protected static final String DIALOG_ERROR_MESSAGE = "incorrect input";
    protected static final String BASIC_PRESS_TO_CONTINUE_TEMPLATE = "press '%s' to continue";
    protected static final String INPUT_BET_TEMPLATE = "[%s] input bet: ";
}
