package org.example.app.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {

    private final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean isDateValid(String date) {
        if (date.isEmpty() || !date.matches(Constants.DATE_RGX)) {
            return true;
        }
        format.setLenient(false);
        try {
            format.parse(date);
            return false;
        } catch (ParseException ex) {
            return true;
        }
    }
}
