package app.ui.console.admin;

import app.controller.App;
import app.controller.RegisterVacineType;
import app.ui.console.utils.Utils;

public class RegisterVacineTypeUI implements Runnable {
    private final RegisterVacineType ctrl = new RegisterVacineType(App.getInstance());


    @Override
    public void run() {
        System.out.println("Register Vaccine Type");
        System.out.println("Enter the name of the vaccine type:");
        String name = Utils.readLineFromConsole("Name: ");
        if (ctrl.registerVacineType(name)) {
            System.out.println("Vaccine type registered!");
        } else {
            System.out.println("Cannot register vaccine type!");
        }
    }
}
