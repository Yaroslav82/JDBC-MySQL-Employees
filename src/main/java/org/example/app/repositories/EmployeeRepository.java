package org.example.app.repositories;

import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository extends BaseRepository<Employee> {

    @Override
    protected Employee resultSetToObject(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt("id"),
                rs.getString("lastName"),
                rs.getString("firstName"),
                rs.getDate("birthDate"),
                rs.getInt("positionId"),
                rs.getString("phone"),
                rs.getDouble("salary")
        );
    }

    @Override
    public String create(Employee employee) {
        String insertSql = "INSERT INTO " + Constants.TABLE_EMPLOYEES + "(lastName, firstName, birthDate, positionId, phone, salary) VALUES (?, ?, ?, ?, ?, ?)";
        return super.create(insertSql, employee.getLastName(), employee.getFirstName(), employee.getBirthDate(), employee.getPositionId(), employee.getPhone(), employee.getSalary());
    }
}
