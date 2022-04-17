package app.ui.console.admin;

import app.controller.App;
import app.controller.RegisterSNSUser;
import app.ui.console.utils.Utils;

public class RegisterSNSUserUI implements Runnable {

    private final RegisterSNSUser ctrl = new RegisterSNSUser(App.getInstance());


    @Override
    public void run() {
        System.out.println("Register SNS User");

        String socailId = Utils.readLineFromConsole("Social Security ID: ");
        String firstName = Utils.readLineFromConsole("First Name: ");
        String middleName = Utils.readLineFromConsole("Middle Names: ");
        String lastName = Utils.readLineFromConsole("Last Name: ");
        String identityCardNumber = Utils.readLineFromConsole("Identity Card Number: ");
        String email = Utils.readLineFromConsole("Email: ");
        String phoneNumber = Utils.readLineFromConsole("Phone Number: ");

        if (ctrl.registerSNSUser(socailId, firstName, middleName, lastName, identityCardNumber, email, phoneNumber)) {
            System.out.println("User registered successfully!");
            return;
        }
        System.out.println("User registration failed!");
    }
}
