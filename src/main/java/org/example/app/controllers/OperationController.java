package org.example.app.controllers;

import org.example.app.services.OperationService;
import org.example.app.utils.AppStarter;
import org.example.app.views.CreateView;

public class OperationController<T> {

    private final OperationService<T> service;
    private final CreateView view;

    public OperationController(OperationService<T> service, CreateView view) {
        this.service = service;
        this.view = view;
    }

    public void create() {
        String[] data = view.getData();
        String str = service.create(data);
        view.getOutput(str);
        AppStarter.startApp();
    }

    public void read() {
        String str = service.read();
        view.getOutput(str);
        AppStarter.startApp();
    }
}
