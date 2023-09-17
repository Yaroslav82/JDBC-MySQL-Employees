package org.example.app.services;

import org.example.app.entities.Employee;
import org.example.app.repositories.BaseRepository;
import org.example.app.utils.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeOperationService extends OperationService<Employee> {

    public EmployeeOperationService(BaseRepository<Employee> repository) {
        super(repository);
    }

    @Override
    public String read() {
        return super.read(Constants.TABLE_EMPLOYEES);
    }

    @Override
    protected Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);

        if (data[1].isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);

        if (DateValidator.isDateValid(data[2]))
            errors.put("data", Constants.WRONG_DATE_MSG);

        if (IdChecker.isIdValid(data[3])) {
            errors.put("position id", Constants.WRONG_ID_MSG);
        } else if (!IdChecker.isIdExists(Integer.parseInt(data[3]))) {
            errors.put("position id", Constants.UNKNOWN_ID_MSG);
        }

        if (PhoneValidator.isPhoneValid(data[4]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        if (SalaryValidator.isSalaryValid(data[5]))
            errors.put("salary", Constants.WRONG_SALARY_MSG);

        return errors;
    }

    @Override
    protected Employee convertData(String[] data) {
        Employee employee = new Employee();

        employee.setFirstName(data[0]);
        employee.setLastName(data[1]);
        employee.setBirthDate(Date.valueOf(data[2]));
        employee.setPositionId(Integer.parseInt(data[3]));
        employee.setPhone(data[4]);
        employee.setSalary(Double.parseDouble(data[5]));

        return employee;
    }
}
