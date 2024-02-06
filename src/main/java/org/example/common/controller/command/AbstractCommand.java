package org.example.common.controller.command;

public abstract class AbstractCommand<T> implements Command{
    protected final T controller;

    protected AbstractCommand(T controller) {
        this.controller = controller;
    }
}
