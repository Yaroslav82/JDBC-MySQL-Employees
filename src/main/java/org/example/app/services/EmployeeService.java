package org.example.app.services;

import org.example.app.controllers.OperationController;
import org.example.app.entities.Employee;
import org.example.app.repositories.BaseRepository;
import org.example.app.repositories.EmployeeRepository;
import org.example.app.views.CreateView;
import org.example.app.views.EmployeeCreateView;

public class EmployeeService extends BaseService<Employee> {

    @Override
    protected OperationController<Employee> getController() {
        CreateView view = new EmployeeCreateView();
        BaseRepository<Employee> repository = new EmployeeRepository();
        OperationService<Employee> service = new EmployeeOperationService(repository);
        return new OperationController<>(service, view);
    }

}
