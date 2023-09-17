package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeReadRepository {

    List<Employee> list;

    public List<Employee> readEmployees() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT * FROM " + Constants.TABLE_EMPLOYEES;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getDate("birthDate"),
                        rs.getInt("positionId"),
                        rs.getString("phone"),
                        rs.getDouble("salary"));

                list.add(employee);
            }

            return list;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
