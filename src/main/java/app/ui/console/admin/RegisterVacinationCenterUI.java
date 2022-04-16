package app.ui.console.admin;

import app.controller.App;
import app.controller.RegisterVacinationCenter;
import app.ui.console.utils.Utils;

public class RegisterVacinationCenterUI implements Runnable {

    private final RegisterVacinationCenter ctrl = new RegisterVacinationCenter(App.getInstance());


    @Override
    public void run() {
        System.out.println("Registering a new vacination center...");
        System.out.print("Enter the name of the center: ");
        String name = Utils.readLineFromConsole("Name :");
        System.out.print("Enter the address of the center: ");
        String address = Utils.readLineFromConsole("Address :");
        System.out.print("Enter the phone number of the center: ");
        String phone = Utils.readLineFromConsole("Phone :");
        System.out.print("Enter the email of the center: ");
        String email = Utils.readLineFromConsole("Email :");
        System.out.println("Enter the website of the center: ");
        String website = Utils.readLineFromConsole("Website :");
        System.out.println("Enter the fax of the center: ");
        String fax = Utils.readLineFromConsole("Fax :");
        System.out.println("Enter the open hours of the center: ");
        String openHours = Utils.readLineFromConsole("Open hours :");
        System.out.println("Enter the close hours of the center: ");
        String closeHours = Utils.readLineFromConsole("Close hours :");
        System.out.println("Enter the vacines slot cap of the center: ");
        int vacinesSlotCap = Utils.readIntegerFromConsole("Vacines slot cap :");
        System.out.println("Enter the slot duration of the center: ");
        int slotDuration = Utils.readIntegerFromConsole("Slot duration :");
        if (ctrl.registerVacinatioinCenter(name, address, phone, email, website, fax, openHours, closeHours, vacinesSlotCap, slotDuration)) {
            System.out.println("Vacination center registered successfully!");
        } else {
            System.out.println("Vacination center registration failed!");
        }
        System.out.println(App.getInstance().getVacinationCenters());
    }
}
