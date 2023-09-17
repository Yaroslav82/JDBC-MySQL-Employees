package org.example.app.controllers;

import org.example.app.services.BaseService;
import org.example.app.utils.Constants;
import org.example.app.utils.OptionChecker;
import org.example.app.views.OptionView;

public class EntityController<T> {

    OptionView view;
    BaseService<T> service;

    public EntityController(OptionView view, BaseService<T> service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.create();
            case 2 -> service.read();
            case 0 -> view.getOutput(Constants.APP_CLOSE_MSG);
            default -> OptionChecker.getNoSuchOption(choice);
        }
    }
}
