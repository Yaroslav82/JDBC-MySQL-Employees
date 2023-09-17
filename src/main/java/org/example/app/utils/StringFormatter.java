package org.example.app.utils;

public class StringFormatter {

    public static String capitalize(String str) {
        return str.toUpperCase().charAt(0) + str.toLowerCase().substring(1);
    }

    public static String removeLast(String str) {
        return str.substring(0, str.length() - 1);
    }
}
