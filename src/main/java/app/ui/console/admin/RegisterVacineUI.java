package app.ui.console.admin;

import app.controller.App;
import app.controller.RegisterVacine;
import app.domain.dto.AdministrationProcessDTO;
import app.domain.dto.OrderDoseDTO;
import app.domain.dto.VacineTypeDTO;
import app.ui.console.utils.Utils;

import java.util.LinkedList;
import java.util.List;

public class RegisterVacineUI implements Runnable {

    RegisterVacine ctrl = new RegisterVacine(App.getInstance());


    @Override
    public void run() {

        System.out.println("Register Vaccine");
        List<VacineTypeDTO> vacineTypes = ctrl.getAllTypes();
        int type = -1;
        while (true) {
            System.out.println("Vaccine Types:");
            for (int i = 0; i < vacineTypes.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, vacineTypes.get(i).getName());
            }
            System.out.println("Enter the number of the type of the vaccine you want to register:");
            type = Utils.readIntegerFromConsole("Choice: ");

            if (type <= vacineTypes.size() && type >= 1) {
                break;
            }
            System.out.println("Invalid choice!");
        }

        System.out.println("Enter the name of the vaccine:");
        String name = Utils.readLineFromConsole("Name: ");
        List<AdministrationProcessDTO> l = requestAdministrationProcesses();

        if (ctrl.registerVacine(name, vacineTypes.get(type - 1), l)) {
            System.out.println("Vaccine registered successfully!");
            return;
        }
        System.out.println("Vaccine registration failed!");
    }

    private List<AdministrationProcessDTO> requestAdministrationProcesses() {
        boolean flag = false;
        List<AdministrationProcessDTO> l = new LinkedList<>();
        do {
            System.out.println("Enter the administration processes:");
            int minAge = Utils.readIntegerFromConsole("Min age: ");
            int maxAge = Utils.readIntegerFromConsole("Max age: ");
            int dose = Utils.readIntegerFromConsole("Dose (ml): ");
            List<OrderDoseDTO> os = requestOrderDoses();
            l.add(new AdministrationProcessDTO(minAge, maxAge, dose, os));
            System.out.println("Do you want to add another administration process? (s/n)");
            if (!Utils.confirm("Choice: ")) {
                flag = true;
            }
        } while (!flag);
        return l;
    }

    private List<OrderDoseDTO> requestOrderDoses() {
        System.out.println("Enter the order doses:");
        boolean flag = false;
        List<OrderDoseDTO> l = new LinkedList<>();
        int doseNumber = 1;
        do {
            int days = Utils.readIntegerFromConsole("Days: ");
            l.add(new OrderDoseDTO(doseNumber, days));
            System.out.println("Do you want to add another order dose? (s/n)");
            if (!Utils.confirm("Choice: ")) {
                flag = true;
            }
            doseNumber++;
        } while (!flag);
        return l;
    }
}
