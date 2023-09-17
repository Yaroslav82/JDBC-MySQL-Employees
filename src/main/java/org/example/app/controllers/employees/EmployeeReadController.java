package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeReadView;

public class EmployeeReadController {

    EmployeeReadView view;
    EmployeeReadService service;

    public EmployeeReadController(EmployeeReadService service, EmployeeReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readEmployees() {
        // Отримуємо результат
        String str = service.readEmployees();
        // Передаємо результа на виведення
        view.getOutput(str);
        AppStarter.startApp();
    }
}
