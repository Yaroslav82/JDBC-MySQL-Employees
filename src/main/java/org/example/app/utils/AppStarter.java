package org.example.app.utils;

import org.example.app.controllers.AppController;
import org.example.app.services.AppService;
import org.example.app.views.OptionView;

public class AppStarter {

    public static void startApp() {
        AppService service = new AppService();
        OptionView view = new OptionView("Main", "Positions", "Employees");
        AppController controller = new AppController(view, service);
        controller.runApp();
    }
}
