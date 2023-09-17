package org.example.app.services;

import org.example.app.controllers.OperationController;

public abstract class BaseService<T> {

    private final OperationController<T> controller;

    public BaseService() {
        controller = getController();
    }

    protected abstract OperationController<T> getController();

    public void create() {
        controller.create();
    }

    public void read() {
        controller.read();
    }
}
