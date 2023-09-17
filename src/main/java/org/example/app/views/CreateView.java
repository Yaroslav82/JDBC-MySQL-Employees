package org.example.app.views;

import java.util.Scanner;

public abstract class CreateView implements View {

    protected static Scanner scanner = new Scanner(System.in);

    protected String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public abstract String[] getData();

    @Override
    public void getOutput(String output) {
        System.out.println(output);
    }
}

