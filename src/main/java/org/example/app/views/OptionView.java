package org.example.app.views;

import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionView implements View {

    private final String title;
    private final String option_1;
    private final String option_2;

    private Scanner scanner;
    private int option;

    public OptionView(String title, String option_1, String option_2) {
        this.title = title;
        this.option_1 = option_1;
        this.option_2 = option_2;
    }

    public int chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void showMenu() {
        System.out.printf("""
                
                ___________ %s Menu ___________
                1 - %s
                2 - %s
                0 - Close the App.
                """, title, option_1, option_2);
    }

    @Override
    public void getOutput(String output) {
        System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
