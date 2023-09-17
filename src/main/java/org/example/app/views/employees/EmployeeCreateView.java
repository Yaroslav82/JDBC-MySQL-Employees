package org.example.app.views.employees;

import java.util.Scanner;

public class EmployeeCreateView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);

        String title = "Enter first name: ";
        System.out.print(title);
        String firstName = scanner.nextLine().trim();

        title = "Enter last name: ";
        System.out.print(title);
        String lastName = scanner.nextLine().trim();

        title = "Enter birth date in format YYYY-MM-DD: ";
        System.out.print(title);
        String birthDate = scanner.nextLine().trim();

        title = "Enter position Id: ";
        System.out.print(title);
        String positionId = scanner.nextLine();

        title = "Enter phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        String phone = scanner.nextLine().trim();

        title = "Enter salary: ";
        System.out.print(title);
        String salary = scanner.nextLine().trim();


        return new String[]{firstName, lastName, birthDate, positionId, phone, salary};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
