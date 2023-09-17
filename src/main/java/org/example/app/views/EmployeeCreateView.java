package org.example.app.views;

public class EmployeeCreateView extends CreateView {

    @Override
    public String[] getData() {
        String firstName = getUserInput("Enter first name: ");
        String lastName = getUserInput("Enter last name: ");
        String birthDate = getUserInput("Enter birth date in format YYYY-MM-DD: ");
        String positionId = getUserInput("Enter position Id: ");
        String phone = getUserInput("Enter phone in format xxx xxx-xxxx: ");
        String salary = getUserInput("Enter salary: ");

        return new String[]{firstName, lastName, birthDate, positionId, phone, salary};
    }
}