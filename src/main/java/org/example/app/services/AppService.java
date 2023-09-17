package org.example.app.services;

import org.example.app.controllers.EntityController;
import org.example.app.entities.Employee;
import org.example.app.entities.Position;
import org.example.app.utils.Constants;
import org.example.app.utils.StringFormatter;
import org.example.app.views.OptionView;

public class AppService {

    public void getPositions() {
        OptionView view = createView(Constants.TABLE_POSITIONS);
        BaseService<Position> service = new PositionService();
        EntityController<Position> controller = new EntityController<>(view, service);
        controller.run();
    }

    public void getEmployees() {
        OptionView view = createView(Constants.TABLE_EMPLOYEES);
        BaseService<Employee> service = new EmployeeService();
        EntityController<Employee> controller = new EntityController<>(view, service);
        controller.run();
    }

    private OptionView createView(String tableName) {
        return new OptionView(StringFormatter.capitalize(tableName),
                "Create a new "  + StringFormatter.removeLast(tableName),
                "View " + tableName);
    }
}
