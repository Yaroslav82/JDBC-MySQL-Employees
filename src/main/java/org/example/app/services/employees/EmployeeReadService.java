package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.repositories.employees.EmployeeReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeReadService {

    EmployeeReadRepository repository;

    public EmployeeReadService(EmployeeReadRepository repository) {
        this.repository = repository;
    }

    public String readEmployees() {

        List<Employee> list = repository.readEmployees();

        if (list != null) {

            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();

                list.forEach(emp -> stringBuilder.append(count.incrementAndGet()).append(") ").append(emp).append("\n"));

                return "\n________Employees_________\n" + stringBuilder;
            }
        }
        return Constants.DATA_ABSENT_MSG;
    }
}
