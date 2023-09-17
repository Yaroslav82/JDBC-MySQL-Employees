package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeCreateView;

public class EmployeeCreateController {

    EmployeeCreateView view;
    EmployeeCreateService service;

    public EmployeeCreateController(EmployeeCreateView view, EmployeeCreateService service) {
        this.view = view;
        this.service = service;
    }

    public void createEmployee() {
        String[] data = view.getData();
        String str = service.createEmployee(data);
        view.getOutput(str);
        AppStarter.startApp();
    }
}
