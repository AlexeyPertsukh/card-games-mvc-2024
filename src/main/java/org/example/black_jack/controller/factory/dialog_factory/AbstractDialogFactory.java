package org.example.black_jack.controller.factory.dialog_factory;

public abstract class AbstractDialogFactory implements DialogFactory{
    protected static final String DEFAULT_CONTINUE_KEY = "y";
    protected static final String BUST_MESSAGE_TEMPLATE = "[%s] can no longer draw cards, press '%s' to continue";
    protected static final String DIALOG_ERROR_MESSAGE = "incorrect input";
    protected static final String BASIC_PRESS_TO_CONTINUE_TEMPLATE = "press '%s' to continue";
    protected static final String DIALOG_INPUT_CMD_TEMPLATE = "[%s] input command: %s - take card, %s - skip";
}
