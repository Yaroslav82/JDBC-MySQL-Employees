package org.example.app.utils;

public class SalaryValidator {

    public static boolean isSalaryValid(String salary) {
        return salary.isEmpty() || !salary.matches(Constants.SALARY_RGX);
    }

}
