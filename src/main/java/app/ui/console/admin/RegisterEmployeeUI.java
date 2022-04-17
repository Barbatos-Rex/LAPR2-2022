package app.ui.console.admin;

import app.controller.App;
import app.controller.RegisterEmployee;
import app.domain.dto.VacinationCenterDTO;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.List;

public class RegisterEmployeeUI implements Runnable {
    private final RegisterEmployee ctrl = new RegisterEmployee(App.getInstance());

    @Override
    public void run() {
        System.out.println("Register Employee");
        String firstName = Utils.readLineFromConsole("First Name: ");
        String lstName = Utils.readLineFromConsole("Last Name: ");
        String email = Utils.readLineFromConsole("Email: ");
        String password = Utils.readLineFromConsole("Password: ");
        while (true) {
            System.out.println("User Roles:");
            List<UserRoleDTO> roles = ctrl.roles();
            for (int i = 0; i < roles.size(); i++) {
                System.out.println(i + 1 + " - " + roles.get(i).getDescription());
            }

            int key = Utils.readIntegerFromConsole("Role: ");

            if (key >= 1 && key <= roles.size()) {
                VacinationCenterDTO vacinationCenter = showVacinationCenters();
                if (ctrl.registerEmployee(firstName, lstName, email, password, roles.get(key - 1), vacinationCenter)) {
                    System.out.println("Employee registered");
                    return;
                }
                System.out.println("Employee not registered");
                return;
            }
            System.out.println("Invalid input");
        }
    }

    private VacinationCenterDTO showVacinationCenters() {
        while (true) {
            System.out.println("Vacination Centers:");
            List<VacinationCenterDTO> vacinationCenters = ctrl.centers();
            for (int i = 0; i < vacinationCenters.size(); i++) {
                System.out.println(i + 1 + " - " + vacinationCenters.get(i).getName());
            }
            int key = Utils.readIntegerFromConsole("Vacination Center: ");
            if (key >= 1 && key <= vacinationCenters.size()) {
                return vacinationCenters.get(key - 1);
            }
            System.out.println("Invalid input");
        }
    }


}
